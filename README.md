# Serverless Spring Boot Application Demo

## Deployment

Deploy the demo to your AWS account using [AWS SAM](https://aws.amazon.com/serverless/sam/).

### Option 1: Managed Java Runtime (without SnapStart)

```bash
mvn clean package
sam deploy -g
```
SAM will create an output of the API Gateway endpoint URL for future use in our load tests. 
Make sure the app name used here matches with the `STACK_NAME` present under `load-test/run-load-test.sh`

### Option 2: Managed Java Runtime (with SnapStart)

```bash
mvn clean package
sam deploy -t template.snapstart.yaml -g
```
SAM will create an output of the API Gateway endpoint URL for future use in our load tests.
Make sure the app name used here matches with the `STACK_NAME` present under `load-test/run-load-test-sanpstart.sh`

The SnapStart version uses a technique called Priming to optimize Lambda initialization time.
You can learn more about SnapStart and Priming [here](https://aws.amazon.com/blogs/compute/reducing-java-cold-starts-on-aws-lambda-functions-with-snapstart/).

### Option 3: GraalVM Native Image with Custom Runtime

On Windows:
```bash
docker run -v <SPRING_BOOT_DIR_ABSOLUTE_PATH>:/project -it --entrypoint /bin/bash marksailes/al2-graalvm:11-22.0.0.2
```
Make sure to replace `SPRING_BOOT_DIR_ABSOLUTE_PATH` with absolute path to springboot directory.

Once docker downloads the image and runs, you would see a bash command that will run inside docker container.
Run below command:

```bash
mvn clean package -Pnative
exit
```
