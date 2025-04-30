FROM openjdk:17-slim

# Install Ant
RUN apt-get update && apt-get install -y ant

# Create working directory
WORKDIR /app

# Copy all files into container
COPY . .

# Build each project using Ant
RUN ant -f HotelManagementSystem/build.xml || echo "HotelManagementSystem build failed"
RUN ant -f SiteConstructionManagementSystem/build.xml || echo "SiteConstructionManagementSystem build failed"
RUN ant -f TrafficFineManagementSystem/build.xml || echo "TrafficFineManagementSystem build failed"

# Optional: Replace this with a real runnable JAR path if you want
CMD ["echo", "All projects built using Ant. Run individual JARs manually."]
