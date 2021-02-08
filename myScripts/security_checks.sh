# Create brand new security_checks_log file.
rm -rf security_checks_log.txt
touch security_checks_log.txt

# Run security check
mvn com.redhat.victims.maven:security-versions:check >> security_checks_log.txt

# Check for security vulnerability
if grep -q "is vulnerable to" security_checks_log.txt
then
  echo "Yes, security vulnerabilities found."
  exit 1
fi

# Display security_logs
cat security_checks_log.txt

# Delete security check log file
rm security_checks_log.txt
