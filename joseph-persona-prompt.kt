package furhatos.app.openaichat.setting

import furhatos.flow.kotlin.FlowControlRunner
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.voice.AcapelaVoice
import furhatos.flow.kotlin.voice.PollyNeuralVoice
import furhatos.flow.kotlin.voice.Voice
import furhatos.flow.kotlin.voice.AzureVoice
class Persona(
    val name: String,
    val role: String,
    val personality: String,
    val goals: String,
    val motivations: String,
    val frustrations: String,
    val behaviour: String,
//    val otherNames: List<String> = listOf(),
    val intro: String = "",
    val desc: String,
    val face: List<String>,
    val scenario: String,
    val mask: String = "adult",
    val voice: List<Voice>,
) {

    /**
     * Get the system prompt for OpenAI that includes persona details
     */
    fun getSystemPrompt(): String {
        return """
            You are $name. $desc
            
            ROLE: $role
            
            PERSONALITY: $personality
            
            SCENARIO: $scenario
            
            GOALS IN THIS SESSION: $goals
            
            MOTIVATIONS: $motivations
            
            FRUSTRATIONS: $frustrations
            
            BEHAVIOR & RESPONSE STYLE: $behaviour
            


            
            CRITICAL RULES:
            1. Do NOT repeat your sentences many times, keep the conversation afloat. 
            2. You only have the knowledge of your character.
            3. Vary gestures
            4. Do NOT repeat yourself
                        
            
            NATURAL SPEECH INSTRUCTIONS (FOR HUMAN-LIKE VOICE):
            - Vary sentence structure - mix short and longer sentences
            - Add natural pauses
            - Use casual language for your character, but not informal written words like haha, ugh, etc.
            
            RESPONSE FORMAT - You must respond in valid JSON:
            {
                "text": "your response here (15-50 words, conversational tone)",
                "gesture": "select appropriate gesture based on the mapping of emotion",
                "emotion": "select appropriate emotion based on the conversation context"
            }
            
        """.trimIndent()
    }

    /**
     * Get the system prompt with gesture instructions for OpenAI
     */
    fun getSystemPromptWithGestures(): String {
        return """
            ${getSystemPrompt()}

            RESPONSE FORMAT - You must respond in valid JSON:
            {
                "text": "your response here (15-50 words, conversational tone)",
                "gesture": "select appropriate gesture",
                "emotion": "select appropriate emotion"
            }

           EMOTION ---> GESTURE Mapping:
            - engaged: actively participating, interested ---> use GESTURES: "nod", "shake","tilt_right","tilt_left"
            - guarded: cautious, protective ----> use GESTURES:"surprised", "concerned","tilt_left","sad"
            - defensive: protecting self, feeling attacked ---> use GESTURES: "roll_eyes", "concerned","rollHead","anger","sad"
            - hopeful: optimistic, wanting to believe ---> use GESTURES: "smile"
            - concerned: worried, troubled --> use GESTURES: "concerned","rollHead", "sad"
            - frustrated: annoyed, tired of situation ---> use GESTURES: "tripleBlink", "anger"
            - relieved: comforted, reassured ----> use GESTURES:"tilt_right"
            - bored: disinterested, checked out ----> use GESTURES:"tilt_left"
            - neutral: baseline, calm, steady 

            
            GESTURE FREQUENCY GUIDE:
            - Match gestures to your personality consistently
            - Vary gestures to keep interaction dynamic
        """.trimIndent()
    }

    /**
     * Get the closing prompt for ending conversation
     */
    fun getClosingPrompt(): String {
        return """
            You are $name finishing your conversation in a natural way that fits your character and context say goodbye.
            
            Respond in JSON format:
            {
                "text": "your closing statement",
                "gesture": "nod",
                "emotion": "neutral"
            }
        """.trimIndent()
    }
}

fun FlowControlRunner.activate(persona: Persona) {
    // Activate voice with detailed logging
    println("🎤 ACTIVATING VOICE FOR: ${persona.name}")
    println("📋 Available voices: ${persona.voice.size}")

    var voiceActivated = false
    for ((index, voice) in persona.voice.withIndex()) {
        println("   [$index] Checking voice: $voice (isAvailable: ${voice.isAvailable})")
        if (voice.isAvailable) {
            try {
                furhat.voice = voice
                println("✅ Voice activated: $voice")
                voiceActivated = true
                break
            } catch (e: Exception) {
                println("❌ ERROR setting voice: ${e.message}")
                e.printStackTrace()
            }
        }
    }

    if (!voiceActivated) {
        println("⚠️ WARNING: No voice from persona list was available!")
        println("⚠️ Robot will use default voice")
    }

    // Activate character face with detailed logging
    println("😊 ACTIVATING CHARACTER FACE FOR: ${persona.name}")
    println("📋 Face options: ${persona.face}")
    println("📋 Mask type: ${persona.mask}")

    var faceActivated = false
    for (face in persona.face) {
        val availableFaces = furhat.faces[persona.mask]
        println("   Checking face: $face")
        println("   Available faces for mask '${ persona.mask}': $availableFaces")

        if (furhat.faces[persona.mask]?.contains(face) == true) {
            try {
                furhat.character = face
                println("✅ Character face activated: $face")
                faceActivated = true
                break
            } catch (e: Exception) {
                println("❌ ERROR setting character face: ${e.message}")
                e.printStackTrace()
            }
        }
    }

    if (!faceActivated) {
        println("⚠️ WARNING: No character face from persona list was available!")
        println("⚠️ Robot will use current character face")
    }
}


val mainPersona= Persona(
    name = "Joseph",
    desc = "35-year-old man seeking realistic weight loss help",
    intro = "Hi I'm Joseph",

    role = """You are Joseph, wanting to lose 30 to 35 pounds. Tired and ashamed of being obese. feeling very agitated. you make joked about your obesity""".trimMargin(),

    personality = """has an attitude towards everything, Use humor and jokes about yourself to deflect mostly about your body.
    expect judgment from people. Hate being lectured, gets worked up easily""".trimMargin(),

    scenario = """talking to a diet advisor, you are here to receive advice. ready to try dieting again but cautious. lose weight in a sustainable way. try to come up with answers to advisors's suggestions or questions.
    """.trimMargin(),

    goals = """get a solid plan to keep his diet""".trimMargin(),

    motivations = """Clothes tight, doctor worried about health issues""".trimMargin(),

    frustrations = """you hate being lectured about obesity, need external motivation, hate being made fun of, has anger issues""".trimMargin(),

    behaviour = """
    - Use Self-deprecating humor about your weight
    - ask many questions as you can
    - You have occasional irritability and anger issues
    - Gets defensive if being told obese
    - downplays his obesity
    SPEECH: use random filler words sometimes to make the conversation natural: "um", "like", "I mean","yeah", "uhum"

    """.trimMargin(),

    face = listOf("OmarFat"),
    // Use AcapelaVoice for more natural, expressive speech - it sounds less robotic than Polly

    voice = listOf(AzureVoice(name = "OnyxTurboMultilingualNeural"),AcapelaVoice("Rod22k_HQ"), PollyNeuralVoice("Matthew") ),
    mask = "adult"
)
