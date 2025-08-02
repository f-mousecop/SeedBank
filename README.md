# 🌱 SeedBank

**SeedBank** is an Android app in progress, developed using Android Studio, designed to help gardeners and green thumbs track their plants and manage gardening tasks. SeedBank is a personal project and my first time getting my feet wet regarding mobile development, which has been a learning experience to say the least. My goal is to continue to improve and add features to SeedBank, providing an intuitive interface and personal companion for organizing and planning your garden throughout the seasons. 

---

## How It's Made:
**Tech Used:** Android Studio, Kotlin, Jetpack Compose, Room (for data persistence), MVVM Architecture, and a little bit of Java 

SeedBank first started as a simple idea, just as the name implies: an app for logging and organizing plant seeds, that has since bloomed with more ideas and features. Before beginning development on SeedBank, I had zero experience with Android/mobile development. Thankfully, Android's developer courses, tutorials, and docs have been a key ingredient in my journey. I first completed some courses learning the fundamentals of Kotlin (which I think is a beautiful language), then became familiar with Android Studio (and quickly realized how complex projects can get).

I continued to read documentation and followed courses learning about Jetpack Compose, mobile UI, state hoisting, navigation, and Android development best practices in app architecture, data persistence, and more. From there, I started to incorporate what I've learned into my application, which continues to be an excellent (and challenging) learning experience.


## Features

### Implemented

#### 🌿 Plant Management
- Add plants into the database with key information:
  - **Name**
  - **Species**
  - **Type** (e.g., herb, vegetable, flower)
  - **Growth time**
  - **Quantity**

#### ☘️ Plant Bank Screen
- Displays entries in a list/card format with the information above
  - Delete functionality to remove an entry from the database

#### 📷 Image & Plant Logs Screens
- Image Log - Displays plant pictures in carousel format
  - Images are currently hard-coded until upload feature is implemented
- Plant Log - Displays plant pictures with names in list/clickable card format
  - Clicking the card will eventually take the user to screen containing plant specifics
  - Similarly, images are hard-coded here

#### 📝 TODO List
- Simple task list tailored for gardening:
  - Add, check off, and delete tasks
  - Completed tasks are shown with strikethrough
  - Tasks persist using Room database

---

### Planned Features

#### Image Uploads
- Attach photos to plant entries *(not yet implemented)*

#### Seed Inventory
- Add and track seed types and quantities *(screen not yet implemented)*

#### Landscape Optimization
- Improve layout for landscape orientation *(planned)*

#### Notifications & Reminders
- Set reminders for watering, fertilizing, etc. *(planned)*

---

#### Screenshots
<img width="30%" alt="Screenshot_20250801_183611" src="https://github.com/user-attachments/assets/82936832-7103-4aca-86d4-aa93840f329e" /><img width="30%" alt="Screenshot_20250801_184337" src="https://github.com/user-attachments/assets/5a05af1c-bae4-4d40-b3d1-6ff2d702c6b7" /><img width="30%" alt="Screenshot_20250801_184454" src="https://github.com/user-attachments/assets/eead3ef5-cb89-433e-91f4-736cc5c7dcf1" />
<img width="30%" alt="Screenshot_20250801_191910" src="https://github.com/user-attachments/assets/b70b0122-f2fb-4d8e-aba9-45aaaf5908b2" /><img width="30%" alt="Screenshot_20250801_191925" src="https://github.com/user-attachments/assets/c8dae6e7-f485-45d9-aaf0-b10a43d44468" />

---
#### Brief Demo of TODOs
![Animation](https://github.com/user-attachments/assets/89e7bf96-c2a5-4160-bae7-97981cc449df)


---
## Getting Started

> This app is still under development and not yet published to the Play Store.

To run:

1. Clone the repository
2. Open in **Android Studio**
3. Build and run on an emulator or device with Android SDK 24+

---

## Roadmap

- [ ] Plant image uploads
- [ ] Seed inventory screen
- [ ] Landscape UI improvements
- [ ] Search & filter for plants
- [ ] Cloud sync via Firebase
- [ ] Calendar view for planting schedule

---

## Contributing

This is a personal learning project, but contributions and feedback are more than welcome! Feel free to open an issue or submit a pull request.
