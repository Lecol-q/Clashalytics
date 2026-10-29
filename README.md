# Introducing Clashalytics

## Current Release: v1.0

Clashalytics v1.0 establishes the foundation of the platform, focusing on player statistics, account management, and personalized player tracking.

### Features in v1.0
- **Player Search:** Search Clash Royale players using their unique player tags.
- **Player Statistics:** View player information, trophies, battle counts, wins, losses, and win rates.
- **User Registration & Login:** Create an account and maintain an authenticated session.
- **Saved Players:** Save and remove player profiles from your personal roster.
- **Persistent Storage:** Store user accounts and saved players using PostgreSQL.
    
Future releases will expand on this foundation with additional player tools, social features, and support for other Supercell games.

# What is Clashalytics?
Clashalytics is a player-focused gaming platform designed to bring the Supercell community closer together, starting with **Clash Royale**.

What begins as a player statistics tracker is intended to grow into a centralized hub where players can explore profiles, track performance, manage their favorite players, and eventually connect with the wider gaming community.

The long-term vision is to create a platform that brings together the tools, information, and social experiences that make Supercell games more engaging.

## Current Features
- **Player Search:** Look up any Clash Royale player using their unique player tag and explore their in-game statistics.
- **Player Profiles:** View important player information, including trophies, wins, losses, and win rate.
- **User Accounts:** Register and log in to your own Clashalytics account.
- **Saved Players:** Build a personal roster of players, making it easy to revisit their profiles and track their statistics.

## Getting Started

### 1. Find a Player Tag

Every Clash Royale player has a unique player tag that can be used to look up their profiles

To find one:

1. Select player name
<img width="750" height="613" alt="pt-home" src="https://github.com/user-attachments/assets/6ba3da07-d991-4ba7-b619-00cdefea6e3b" />



2. Select player tag
<img width="750" height="613" alt="pt-profile" src="https://github.com/user-attachments/assets/a8b9d0d6-b93b-4cb5-92a8-34ceac659168" />


3. Copy tag, or enter manually
<img width="750" height="613" alt="pt-copy" src="https://github.com/user-attachments/assets/44cdc844-1bf5-4d8c-90bb-44a9239e816a" />


### 2. Explore Player Statistic
Enter the player tag into the search bar to retrieve their profiles.

![[Screenshot 2026-10-29 at 7.13.27 PM.png]]

Clashalytics displays key statistics such as:
- Player name
- Trophy count
- Total battkes
- Wins and losses
- Win rate

### 3. Build your Player Roster

Create a Clashalytics account to unlock the ability to save players.

Once logged in, you can add players to your personal roster and revisit their profiles whenever you want. You can also remove players from your roster at any time.
![[Screenshot 2026-10-29 at 7.15.03 PM.png]]


## The Roadmap: Building Something Bigger

Player statistics are just the beginning. The long-term goal is to transform Clashalytics into a much broader gaming platform, with features that bring together competitive tools, player discovery, and community interaction.

### Expanding the Clash Royale Experience

Planned features include:
- **Card Collections:** Explore and manage player card collections.
- **Deck Builder:** Create, customize, and share decks.
- **Leaderboards:** Discover top players and compare competitive performance.
- **Social Posts:** Share updates, strategies, and experiences with other players.
- **Direct Messaging:** Connect and communicate with other members.
- **News Feed:** Keep up with game updates, community discussions, and relevant news.

### Beyond Clash Royale

The vision doesn't stop with one game. Future expansion plans include other Supercell titles, such as:
- Clash of Clans
- Brawl Stars

## Technical Overview

Clashalytics is a full-stack web application built with a Java Spring Boot backend and a React frontend. The application follows a layered architecture, separating API communication, business logic, data persistence, and presentation.

### Technology Stack

|Layer|Technologies|
|---|---|
|Frontend|React, JavaScript, HTML, CSS|
|Backend|Java 25, Spring Boot|
|API Integration|Spring RestClient, RoyaleAPI Proxy|
|Database|PostgreSQL, Neon|
|Data Persistence|Spring Data JPA, Hibernate|
|Authentication|Spring Security, BCrypt password hashing|
|Build & Deployment|Maven, Docker, Render|
|Version Control|Git, GitHub|

### Architecture & Implementation

**Frontend — React**

The frontend is built with React and JavaScript, providing an interactive interface for player searches, account management, and saved player profiles. React handles component rendering, application state, and communication with the backend through HTTP requests.

**Backend — Spring Boot**

The backend exposes REST endpoints responsible for handling client requests and coordinating application functionality. Its layered structure separates responsibilities across controllers, services, repositories, and models.

- **Controllers:** Handle HTTP requests and return appropriate responses.
- **Services:** Contain application logic and coordinate operations.
- **Repositories:** Manage database interactions through Spring Data JPA.
- **Models:** Represent application entities and data structures.
    

**External API Integration**

Clashalytics integrates with the Clash Royale API through the RoyaleAPI proxy. The backend uses Spring's `RestClient` to retrieve player information, deserialize JSON responses into Java objects using Jackson, and expose the resulting statistics through its own REST endpoints.

**Database & Authentication**

PostgreSQL provides persistent storage for user accounts and saved player profiles. Spring Data JPA and Hibernate handle object-relational mapping and database operations.

User authentication is implemented using Spring Security, with BCrypt password hashing to protect stored credentials. Authenticated sessions allow users to maintain their login state and manage their personal player rosters.

**Deployment & Infrastructure**

The application is containerized using Docker and deployed through Render. The React production build is packaged into the Spring Boot application's static resources, allowing the frontend and backend to run together as a single web service.

The production database is hosted on Neon, providing managed PostgreSQL infrastructure independently of the application container.

### Engineering Considerations

Some of the primary engineering goals behind Clashalytics include:
- Separation of concerns through a layered backend architecture.
- Secure password storage and session-based authentication.
- Persistent user data and player profile management.
- External API integration and JSON data processing.
- Containerized deployment and production environment configuration.
- Maintaining a clear separation between frontend presentation and backend application logic.
