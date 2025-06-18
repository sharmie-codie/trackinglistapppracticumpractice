# Tracking App - README

![App Logo](assets/app_icon.png) <!-- Replace with your app's icon -->

## Description
The Tracking App helps Android users monitor their daily activities, habits, and personal goals through an intuitive interface. This project solves the challenge of personal accountability by providing an easy-to-use mobile solution for tracking progress over time.

## Screenshots
| Splash Screen | Main Dashboard | Tracking Screen | Progress Report |
|--------------|---------------|----------------|----------------|
| ![Splash](assets/splash.png) | ![Dashboard](assets/dashboard.png) | ![Tracking](assets/tracking.png) | ![Report](assets/report.png) |

## Features
- 📝 **Custom Trackers**: Create trackers for various metrics (time, count, yes/no)
- 📊 **Progress Visualization**: View trends through interactive charts
- 🔔 **Reminders**: Set notifications for consistent tracking
- 🎯 **Goal Setting**: Define and monitor personal targets
- 📤 **Data Export**: Share reports in CSV or PDF format
- 🌙 **Dark Mode**: Eye-friendly night theme

## Technology Stack
- **Language**: Kotlin
- **Development Environment**: Android Studio
- **Version Control**: GitHub with GitHub Actions CI/CD
- **Key Components**:
  - Room Database (local storage)
  - MPAndroidChart (data visualization)
  - WorkManager (background tasks)
- **Architecture**: MVVM with Single Activity

## Usage
1. **Launch the app** from your device
2. **Create a tracker**:
   - Tap "+" on the dashboard
   - Select tracker type (number, time, or checkbox)
3. **Log your progress**:
   - Select a tracker
   - Enter today's value
4. **View reports**:
   - Swipe between daily/weekly/monthly views
   - Tap charts for detailed analysis
5. **Export data** (optional):
   - Open tracker details
   - Tap "Share" to export

## Development Details
### Purpose
The Tracking App was designed to:
- Help users build consistent habits
- Provide visual feedback on progress
- Make personal accountability accessible

### Design Considerations
#### User Experience
- Simple three-screen flow (Dashboard → Tracking → Reports)
- Minimalist interface for quick logging
- Customizable trackers for flexibility

#### Technical Implementation
- **Database**: Room for local data persistence
- **Navigation**: Single Activity with Fragments
- **State Management**: ViewModel for UI data
- **Charts**: MPAndroidChart for visualizations

### GitHub Integration
- **Version Control**:
  - Feature branch workflow
  - Semantic commit messages
- **GitHub Actions**:
  - Automated builds on push
  - Linter checks for code quality

## Future Enhancements
1. ☁️ **Cloud Sync**: Firebase integration for multi-device access
2. 👥 **Social Features**: Share progress with friends
3. 🤖 **AI Insights**: Predictive analytics based on habits
4. 📱 **Widgets**: Quick-log from home screen
5. 🎨 **Custom Themes**: Personalize the app appearance

## References
- [Android Developer Documentation](https://developer.android.com)
- [Room Database Guide](https://developer.android.com/training/data-storage/room)
- [MPAndroidChart Documentation](https://weeklycoding.com/mpandroidchart-documentation/)
