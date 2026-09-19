# Hiker guide
> A small Java library and Swing desktop app for planning trip logistics — provisions and equipment — for different tour types (mountain climbing, sightseeing, kayaking). Built with Maven and a Jenkins CI pipeline as a university course project.

## What's in this repository
This repo holds the CI configuration and the built artifact from a two-module Maven project (`tourPlanningApp` + `tourPlanningLibrary`); the full source lived in a separate, private university Git repository and isn't included here.

- `Jenkinsfile` – Jenkins pipeline that builds the app with Maven and publishes the library module to a Maven repo
- `Tour Planner.jar` – the built Swing desktop application (entry point: `pl.edu.pwr.tourPlanningApp.App`)

Packages inside the jar:
- `pl.edu.pwr.tourPlanningApp` – the Swing GUI (`TourPlanningFrame`)
- `pl.edu.pwr.tourPlanningLibrary` – domain classes: `Tour`, `MountainClimbing`, `Sightseeing`, `Kayaking`

## Run
```
java -jar "Tour Planner.jar"
```

## Status
**Archived** — not actively maintained.

Written in 2019 for a Java/Maven coursework project (Wrocław University of Science and Technology). Only the CI pipeline and the built jar are published here — the app/library source itself lived in a separate university repository.
