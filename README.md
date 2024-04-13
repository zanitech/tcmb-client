# tcmb-client

Java sdk that connects central bank (TCMB) and provides TCMB related data. 

To use it (not ready yet) as a maven dependency, add the following;

```
<dependency>
    <groupId>com.zanitech.sdk</groupId>
    <artifactId>tcmb-client</artifactId>
    <version>1.0.0</version>
</dependency>
```
## Example Usage
```
TcmbClient tcmbClient = new TcmbClient();
ForexRateResponse forexRateResponse = tcmbClient.forex().getRates();
```
