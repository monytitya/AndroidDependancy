# Implementation Plan - Fix Project Mistakes

This plan addresses several errors and inconsistencies in the project, including package mismatches, file naming errors, incorrect repository instantiation, and missing Compose dependencies.

## User Review Required

> [!IMPORTANT]
> I will be standardizing the package name to `com.example.arc_dp` across all files to match the project's namespace. This involves moving `MovieViewModel.kt` and updating package declarations in all source files.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Android2026/ANDROIDS26/Arc_Dp/gradle/libs.versions.toml)
- Add `androidx-lifecycle-runtime-compose` and `androidx-lifecycle-viewmodel-compose` libraries.

#### [MODIFY] [build.gradle.kts](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/build.gradle.kts)
- Add the new lifecycle dependencies.

---

### Data & Repository Layer

#### [NEW] [Movie.kt](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/src/main/java/com/example/arc_dp/data/Movie.kt)
- Create correctly named file with correct package `com.example.arc_dp.data`.

#### [DELETE] [Moview.kt](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/src/main/java/com/example/arc_dp/data/Moview.kt)
- Remove file with typo in name.

#### [MODIFY] [MovieRepository.kt](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/src/main/java/com/example/arc_dp/repository/MovieRepository.kt)
- Update package to `com.example.arc_dp.repository`.
- Update import for `Movie`.
- Remove unused `android.R.id` import.

---

### ViewModel Layer

#### [NEW] [MovieViewModel.kt](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/src/main/java/com/example/arc_dp/viewmodel/MovieViewModel.kt)
- Create in correct package `com.example.arc_dp.viewmodel`.
- Fix `repository` instantiation (was instantiating itself).
- Rename `movie` StateFlow to `movies`.
- Use idiomatic `emptyList()` instead of `Collections.emptyList`.

#### [DELETE] [MovieViewModel.kt](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/src/main/java/MovieViewModel.kt)
- Remove from root `java` folder.

---

### UI Layer

#### [MODIFY] [MovieScreen.kt](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/src/main/java/com/example/arc_dp/ui/MovieScreen.kt)
- Update package to `com.example.arc_dp.ui`.
- Fix imports for `viewModel()`, `items()`, and `collectAsStateWithLifecycle()`.
- Fix `MovieItem` call inside `LazyColumn` (passing the list instead of individual item).
- Fix property reference to `viewModel.movies`.

#### [MODIFY] [MainActivity.kt](file:///C:/Android2026/ANDROIDS26/Arc_Dp/app/src/main/java/com/example/arc_dp/MainActivity.kt)
- Update package to `com.example.arc_dp`.
- Fix `MovieAppTheme` (currently an annotation). I'll create a simple MaterialTheme wrapper for now.

## Verification Plan

### Automated Tests
- Run `gradle build` to ensure all compilation errors and package mismatches are resolved.

### Manual Verification
- Deploy the app to a device/emulator to verify that the movie list is displayed correctly.
