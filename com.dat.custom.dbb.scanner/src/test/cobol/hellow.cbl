       IDENTIFICATION DIVISION.
       PROGRAM-ID.     HELLO.
       DATA DIVISION.
      * COPYRIGHT
       WORKING-STORAGE SECTION.
       01  BLANK-MSG                        PIC X(1) VALUE ' '.
           COPY SAMP.
      *    %INC SAMP.
      *    PCOPY SAMP.
      *    PULL SAMP.
      *    MACS=(SAMP1,SAMP2,SAMP3)

       PROCEDURE DIVISION.
           DISPLAY "Hello world!".

           STOP RUN.