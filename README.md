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
- **Java 25** installed on your machine
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
   java -jar target/war-game-simulation-1.0.0.jar src/main/resources/config-sample.json
   ```
   
   Or run directly through Maven:
   ```bash
   mvn exec:java -Dexec.mainClass="app.Driver" -Dexec.args="src/main/resources/config-sample.json"
   ```

4. **Run tests**
   ```bash
   mvn test
   ```

### Development in IntelliJ IDEA

1. Open the project in IntelliJ
2. Maven dependencies will automatically download
3. Right-click on `Driver.java` → **Run 'Driver.main()'** to execute with sample config as argument
4. To pass the config file: Edit `Driver.java` run configuration and add program arguments: `src/main/resources/config-sample.json`

### Development in Eclipse

1. **Import the project into Eclipse**
   - Open Eclipse and go to **File** → **Import**
   - Select **Maven** → **Existing Maven Projects**
   - Browse to the project root directory and click **Finish**
   - Eclipse will automatically configure the project based on `.project`, `.classpath`, and Maven settings

2. **Configure JRE (if needed)**
   - Right-click on the project → **Properties**
   - Select **Project Facets**
   - Ensure Java version is set to 25 or later
   - If JRE is not configured, go to **Java Build Path** → **JRE System Library**
   - Click **Edit** and select or install Java 25

3. **Run tests**
   - Right-click on the project → **Run As** → **Maven test**
   - Or right-click on a test class → **Run As** → **JUnit Test**

4. **Run the application**
   - Right-click on `Driver.java` → **Run As** → **Java Application**
   - To pass the configuration file, you may need to create a **Run Configuration**:
     - Go to **Run** → **Run Configurations**
     - Create a new **Java Application** configuration
     - Set Main class to `app.Driver`
     - In Arguments tab, set Program arguments to: `src/main/resources/config-sample.json`

## Project Structure

```
war-game/
├── .project                           # Eclipse project configuration
├── .classpath                         # Eclipse classpath configuration
├── .settings/                         # Eclipse IDE settings
│   ├── org.eclipse.jdt.core.prefs    # Java compiler settings
│   └── org.eclipse.m2e.core.prefs    # Maven settings
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── algo/                 # AI algorithms
│   │   │   │   ├── Minimax.java
│   │   │   │   ├── AlphaBetaPruning.java
│   │   │   │   ├── Random.java
│   │   │   │   └── TreeNode.java     # Generic tree for game states
│   │   │   ├── app/                  # Application entry points
│   │   │   │   ├── Driver.java       # Main entry point
│   │   │   │   └── MainApp.java      # Core game logic
│   │   │   └── model/                # Game entities
│   │   │       └── map/
│   │   │           └── Board.java    # Game board with pieces
│   │   └── resources/
│   │       └── config-sample.json    # Sample game configuration
│   └── test/java/                    # Unit tests (with JUnit 4)
├── target/                           # Build output (generated)
├── .gitignore                        # Git ignore rules
├── pom.xml                           # Maven configuration
└── README.md                         # This file
```

### Configuration Files

- **`config-sample.json`**: Sample configuration for a 9x9 board with two AI players
  - Located in `src/main/resources/`
  - Defines board dimensions, player settings, and AI strategies
  - Can be used as a template for custom game configurations

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

- **Java 25** - Core language (with preview features enabled)
- **Maven 3.6+** - Build automation & dependency management
- **JUnit 4** - Testing framework
- **Spring Boot** *(planned)* - REST API framework
- **React** *(planned)* - Frontend UI framework

## Contributing

This is a learning-focused project. Contributions and suggestions are welcome!

## License

See [LICENSE](LICENSE) file for details.

---

**Status**: 🚧 Under Development | **Last Updated**: April 2026
