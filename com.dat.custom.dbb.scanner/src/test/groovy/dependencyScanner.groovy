import com.dat.custom.dbb.scanner.DATDependencyScanner
import com.ibm.dbb.dependency.*

/*
 * This script  and the sample test program nede 
 * to go on USS to invoke the new scanner
 * 
 * Invoke this script via groovyz:
 * 
 * groovyz  -cp /u/dbehm/dbb-scanner/com.dat.custom.dbb.scanner.jar dependencyScanner.groovy
 * 
 */

String buildFile = "MortgageApplication/cobol/hellow.cbl"
String workspace = "/u/dbehm/userBuild"

// creating own scanner
def scanner = new DATDependencyScanner()

// scanning file
LogicalFile logicalFile = scanner.scan(buildFile, workspace)

//listing file
println logicalFile