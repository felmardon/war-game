# War Game Simulation

A Java-based turn-based strategy game simulation featuring competitive AI algorithms and dynamic gameplay mechanics.

## Project Aim

The goal of War Game Simulation is to:
- **Experiment with AI algorithms** - Implement and compare different decision-making strategies (Minimax, Alpha-Beta Pruning, Random)
- **Develop game mechanics** - Build a robust board-based game system with turn management and state evaluation
- **Learn systems design** - Create scalable, well-structured code for growing complexity
- **Bridge desktop and web** - Eventually transition this to an interactive browser-based web application

## Current State

The project is currently in **early development** as a standalone Java application with:
- ✅ Core game infrastructure (Board, Pieces, Squares)
- ✅ Multiple AI algorithms for move evaluation
- ✅ Maven-based project structure for easy dependency management
- ⚙️ Basic game rendering and player management (in progress)
- ❌ Full game rules and win conditions (not yet implemented)
- ❌ Web UI (planned for future)

## How to Run Locally

### Prerequisites
- **Java 11+** installed on your machine
- **Maven 3.6+** installed
- **Git** (optional, for cloning)

### Setup & Run

1. **Clone or download the project**
   ```bash
   git clone https://github.com/YOUR_USERNAME/war-game.git
   cd war-game
   ```

2. **Build the project**
   ```bash
   mvn clean package
   ```

3. **Run the application**
   ```bash
   java -jar target/war-game-simulation-1.0.0.jar <config-file>
   ```
   
   Or run directly through Maven:
   ```bash
   mvn exec:java -Dexec.mainClass="app.Driver" -Dexec.args="<config-file>"
   ```

4. **Run tests** (when available)
   ```bash
   mvn test
   ```

### Development in IntelliJ IDEA

1. Open the project in IntelliJ
2. Maven dependencies will automatically download
3. Right-click on `Driver.java` → **Run 'Driver.main()'** to execute

## Project Structure

```
war-game/
├── src/
│   ├── main/java/
│   │   ├── algo/              # AI algorithms
│   │   │   ├── Minimax.java
│   │   │   ├── AlphaBetaPruning.java
│   │   │   ├── Random.java
│   │   │   └── TreeNode.java  # Generic tree for game states
│   │   ├── app/               # Application entry points
│   │   │   ├── Driver.java    # Main entry point
│   │   │   └── MainApp.java   # Core game logic
│   │   └── model/             # Game entities
│   │       └── map/
│   │           └── Board.java # Game board with pieces
│   ├── test/java/             # Unit tests
│   └── main/resources/        # Config files, assets
├── pom.xml                    # Maven configuration
└─��� README.md
```

## Future State: Web Application

The end goal is to transition War Game Simulation into a **browser-based web application** with:

### Phase 2: Enhanced Desktop Version
- Complete game rules and win conditions
- Networked multiplayer support
- GUI using JavaFX or Swing
- Configuration file system for board setup
- Game replay and analysis tools

### Phase 3: Web Migration
- **Backend**: Java Spring Boot REST API
- **Frontend**: React or Vue.js for interactive UI
- **Deployment**: Docker containerization
- **Real-time gameplay**: WebSocket support for live multiplayer
- **Database**: Persistent game state storage
- **Analytics**: Game statistics and AI performance tracking

## Technologies & Dependencies

- **Java 11** - Core language
- **Maven** - Build automation & dependency management
- **JUnit 4** - Testing framework
- **Spring Boot** *(planned)* - REST API framework
- **React** *(planned)* - Frontend UI framework

## Contributing

This is a learning-focused project. Contributions and suggestions are welcome!

## License

See [LICENSE](LICENSE) file for details.

---

**Status**: 🚧 Under Development | **Last Updated**: April 2026
