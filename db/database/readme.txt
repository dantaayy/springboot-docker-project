Dockerfile contains how to create postgres image

Have to set env variables for db login

Create the database with ENV POSTGRES_DB

Copy the sql dump files to load the data (COPY fileName.sql /docker-entrypoint-initdb.d/)

To build the docker file:
	// This builds the docker image and names it my-postgres-db
	docker build -t my-postgres-db ./

	// Create the docker container with the image we just built
	docker create --name postgres-database -p 5432:5432 my-postgres-db

To Build the java app
	
	- Specify image type
	- Set workdir in this case is the app itself
	- Add the jar file to the image (it contains everything we need)
	- Specify the command to run the app
	- Let docker know what port to use

	// This builds the docker image and names it springboot-app
	docker build -t springboot-app .

	// Run the docker container with the image we just built in detached mode on port 5555
	docker run -dp 5555:5555 springboot-app

