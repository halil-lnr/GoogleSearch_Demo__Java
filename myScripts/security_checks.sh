# Create brand new security_checks_log file.
rm -rf security_checks_log.txt
touch target/security_checks_log.txt

# Run security check
mvn com.redhat.victims.maven:security-versions:check >> target/security_checks_log.txt

# Check for security vulnerability
if grep -q "is vulnerable to" target/security_checks_log.txt
then
  echo "Yes, security vulnerabilities found."
  exit 1
fi

# Display security_logs
cat target/security_checks_log.txt

# Delete security check log file
rm target/security_checks_log.txt
