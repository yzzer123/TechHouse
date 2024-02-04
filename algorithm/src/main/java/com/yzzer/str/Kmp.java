package com.yzzer.str;

public class Kmp {
  public int[] getNext(char[] subStr) {
    int[] next = new int[subStr.length];
    next[0] = -1;
    int i = 0, j = -1;
    while(i < subStr.length - 1) {
      if (j == -1 || subStr[i] == subStr[j]) {
        i++; j++;
        if (subStr[i] == subStr[j]) {
          next[i] = next[j];
        } else {
          next[i] = j;
        }
      } else {
        j = next[j];
      }
    }

    return next;
  }

  public int indexOf(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    } else if (needle.length() == haystack.length()) {
      return needle.equals(haystack) ? 0 : -1;
    }

    char[] module = haystack.toCharArray();
    char[] parttern = needle.toCharArray();

    int[] next = getNext(parttern);

    int i = 0, j = 0;
    while (i < module.length && j < parttern.length) {
      if (j == -1 || parttern[j] == module[i]) {
        i++; j++;
      } else {
        j = next[j];
      }
    }
    return j == parttern.length ? i - j : -1;
  }
}
