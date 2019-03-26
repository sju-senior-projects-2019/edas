# read in EDF data using edfReader package
require( edfReader )
hdr = readEdfHeader( "/Users/allisonsmith/Downloads/00000355_s003_t000.edf" )

# read in data header and extract specific data to print using print() function and $ selector
summary( hdr )
print( hdr$nSignals )
print( hdr$sHeaders )
print( hdr$nRecords )
print( hdr$patient )
print ( hdr$recordingId )

# read in signals data and create overal summary
sig = readEdfSignals( hdr )
summary( sig )

# plot FPI channel
plot( sig$`EEG FP1-REF`$signal, type="l" )

# create a multi-paneled plotting window using par() function to display FPI channel alongside PHOTIC-REF light stimuli
par( mfrow=c(2,1) ) 
plot( sig$`PHOTIC-REF`$signal,  type="l", ylab="photic" )
plot( sig$`EEG FP1-REF`$signal, type="l", ylab="fp1"    )

# overlay FPI Channel and PHOTIC-REF stimuli in single plotting window w/ customized colors
par( mfrow=c(1,1) ) 
plot( sig$`PHOTIC-REF`$signal,  type="l", ylab="photic", col="gray" )
lines( sig$`EEG FP1-REF`$signal, col="blue" )

# calculate correlation between signal and photic-ref stimuli
cor( sig$`EEG FP1-REF`$signal, sig$`EEG FP2-REF`$signal, method="pearson" )
cor( sig$`EEG FP1-REF`$signal, sig$`PHOTIC-REF`$signal,  method="pearson" )

# next steps: understand and incorporate fft() function
f <- fft(sig$`EEG FP1-REF`$signal, inverse=FALSE)
plot(f, type = "h", main = "attempt 1 graphing fft", ylab = "?", xlab = "?")
