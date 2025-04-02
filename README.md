# Credits Plugin for Minecraft 1.21.4

spigot plugin that allows u (the admin) to credit ppl for their work and allows ur players to run /credits to see the credits

## Features

- `/credits` command to display credits to all players
- `/editcredits` command to add and remove credits (requires permission)
- persistent storage of credits in config.yml

## Commands

- `/credits` - shows the credits to the player
- `/editcredits add <text>` - adds a new credit line
- `/editcredits remove <number>` - removes a credit line by its number
- `/editcredits list` - lists all credit lines with their numbers

## Permissions

- `credits.view` - Allows players to view credits (default: true)
- `credits.edit` - Allows players to edit credits (default: op)

## Installation

1. download the latest release JAR file
2. place the JAR file in your server's `plugins` folder
3. restart your server
4. edit the configuration in `plugins/Credits/config.yml` if u want (for colors maybe)

## Development Setup

To build this plugin from source, you'll need:

1. **Java Development Kit (JDK) 17 or newer**
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK
   - Set up JAVA_HOME environment variable

2. **Maven**
   - Download from [Maven's official site](https://maven.apache.org/download.cgi)
   - Add Maven to your PATH

3. **Build the plugin**
   ```bash
   mvn clean package
   ```
   
4. The compiled JAR will be in the `target` directory

## Configuration

The plugin creates a default configuration file at `plugins/Credits/config.yml`:

```yaml
# Credits Plugin Configuration

# List of credit lines to display
# You can use color codes with the § symbol
credits:
  - "§6Created by: YourName"
  - "§bThanks for using this plugin!"
```

You can edit this file to customize the default credits.

## Color Codes

You can use Minecraft color codes in your credits by using the § symbol followed by a code:

- §0: Black
- §1: Dark Blue
- §2: Dark Green
- §3: Dark Aqua
- §4: Dark Red
- §5: Dark Purple
- §6: Gold
- §7: Gray
- §8: Dark Gray
- §9: Blue
- §a: Green
- §b: Aqua
- §c: Red
- §d: Light Purple
- §e: Yellow
- §f: White

Formatting codes:
- §l: Bold
- §m: Strikethrough
- §n: Underline
- §o: Italic
- §r: Reset
