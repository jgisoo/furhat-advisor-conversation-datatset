# furhat-advisor-conversation-datatset

# [Dataset Name]

> Recommended length for the paper title: ≤110 characters. Keep this repo title consistent with your paper title.

**Paper:** [Title of accompanying short paper] (HRI 20XX, Data Submission track)
**Authors:** [Anonymized during review — list names/affiliations in camera-ready]
**Contact:** [anonymized-email@example.com]
**License:** [e.g., CC BY 4.0 / MIT — see LICENSE file]
**Persistent identifier / DOI:** [Add once archived on Zenodo/Dataverse/etc. — GitHub alone is not sufficient for long-term preservation]

---

## Abstract

<!-- Max 170 words. One paragraph summarizing what the dataset is, how it was collected, and why it matters to the HRI community. -->

[Write here]

---

## Table of Contents

- [Study Overview](#study-overview)
- [Methods](#methods)
- [Dataset](#dataset)
- [Usage Notes](#usage-notes)
- [Ethics & Human Subjects](#ethics--human-subjects)
- [Licensing & Maintenance Plan](#licensing--maintenance-plan)
- [Reproducibility](#reproducibility)
- [Citation](#citation)
- [References](#references)

---

## Study Overview

<!-- Overview of the study that generated the data and its potential use. Include prior publications using this data, if any. -->

- **Research context / motivation:**
- **Study design summary (brief; full detail goes in Methods):**
- **Prior publications using this dataset (if applicable):**
- **What makes this dataset useful/novel for the HRI community:**

---

## Methods

<!-- Steps taken to produce the data: experimental design, data acquisition, computational processing, questionnaires. -->

### Participants
- Recruitment method:
- Sample size and demographics:
- Inclusion/exclusion criteria:

### Experimental Design
- Study conditions / independent variables:
- Procedure (step-by-step):
- Robot platform(s) / hardware used (make, model, software version):
- Environment/setting (lab, field, in-the-wild):

### Data Acquisition
- Sensors/modalities recorded (video, audio, motion capture, physiological, logs, etc.):
- Recording equipment and specifications:
- Sampling rate / resolution / frame rate (as applicable):

### Questionnaires / Measures (if applicable)
- Instrument name(s) and citation:
- Individual items and scoring (include in full, or link to appendix):
- Administration timing (pre/post/during):

### Post-processing
- Cleaning, filtering, synchronization, or annotation steps:
- Annotation/coding scheme and inter-rater reliability (if applicable):
- Software/scripts used (link to code, with versions):

---

## Dataset

<!-- Detailed description of the dataset itself: structure, formats, size, maintenance. -->

### Contents & Structure
```
dataset/
├── raw/                # raw sensor/log data
├── processed/          # cleaned/processed data
├── annotations/        # labels, codings, transcripts
├── questionnaires/      # survey responses and scoring keys
├── metadata.csv         # participant/session-level metadata
└── docs/                # data dictionary, codebooks
```

### File Formats
| File type | Format | Description |
|---|---|---|
| e.g. video | .mp4 | ... |
| e.g. motion | .csv | ... |
| e.g. audio | .wav | ... |

### Size
- Total size:
- Number of participants/sessions/trials:
- Duration (if time-series/video):

### Data Dictionary
- Link or table describing each variable/column, units, and allowed values: [docs/data_dictionary.md]

### Data Maintenance
- Repository where the full dataset is permanently archived (Zenodo/Dataverse/Dryad/Figshare/etc.), with DOI:
- Versioning scheme:
- Point of contact for corrections/updates:

---

## Usage Notes

<!-- Guidance for researchers using the data: ethical use, responsible use, utility, relevance. -->

- **How to load/use the data (quick start):**
- **Known limitations / biases:**
- **Recommended and discouraged uses:**
- **Utility and relevance to HRI research (why this matters going forward):**

---

## Ethics & Human Subjects

> Required if the dataset includes human-subjects data. Be explicit — reviewers will check this section.

- **IRB/ethics board approval:** [Board name, protocol/approval number] — or explicitly state that no board was involved and why.
- **Approval for data sharing:** [Confirm the approval/consent covers public sharing of this data, not just the original study.]
- **Consent process:** [How informed consent was obtained; whether participants consented to data sharing/reuse.]
- **Participant selection:** [How subjects were recruited/selected.]
- **Anonymization / de-identification:** [What identifying information was removed; note any redacted/blacked-out segments and why.]
- **Sensitive or restricted content:** [If any portion cannot be shared openly (e.g., faces, voices, transcripts with identifying info), describe what was withheld and the process for other researchers to request access, e.g., data use agreement, additional ethics approval.]

---

## Licensing & Maintenance Plan

- **License:** [Name + link, e.g., CC BY 4.0, ODC-BY, MIT for accompanying code] — see [opensource.org/licenses](https://opensource.org/licenses/) for options.
- **Long-term hosting:** [Primary archive — Zenodo/Dataverse/etc. — with DOI; GitHub repo mirrors documentation/code.]
- **Update/maintenance plan:** [Who maintains it, how long, how updates/corrections are issued.]
- **Access restrictions (if any):** [Clear criteria and mechanism for requesting access to restricted portions.]

---

## Reproducibility

<!-- Encouraged: outline steps to reproduce collection, post-processing, and usage. Include reference code where possible. -->

- **Reference code repository:** [link]
- **Steps to reproduce data collection:**
- **Steps to reproduce post-processing/analysis:**
- **Environment/dependencies:** [languages, libraries, versions]

### Data Visualization
<!-- Recommended: include a figure/notebook illustrating key aspects of the dataset. -->
- [Link to notebook or figure in docs/]

---

## Citation

```bibtex
@inproceedings{yourkey20XX,
  title     = {Title of the Paper},
  author    = {Author One and Author Two},
  booktitle = {Proceedings of the ACM/IEEE International Conference on Human-Robot Interaction (HRI)},
  year      = {20XX}
}
```

---

## References

<!-- Cite prior work, instruments used, reproducibility best practices, etc. -->

1.
2.

---

## Checklist Before Submission

- [ ] Title ≤110 characters
- [ ] Abstract ≤170 words
- [ ] Study Overview, Methods, Dataset, Usage Notes sections complete
- [ ] IRB/ethics approval and consent process clearly stated (or explicitly noted as N/A)
- [ ] Anonymization of participants confirmed; sensitive segments handled/redacted
- [ ] Open-source/open-data license selected and included
- [ ] Data hosted on a long-term repository with a permanent identifier (DOI), not just GitHub
- [ ] Data dictionary / codebook included
- [ ] Reference/analysis code linked, with dependencies documented
- [ ] Questionnaire items and scoring included (if applicable)
- [ ] Repository and all files fully anonymized for double-blind review (no names, emails, institutional identifiers in code/comments/metadata)
- [ ] Representative sample zipped and attached as supplementary material (if full dataset too large to submit)
