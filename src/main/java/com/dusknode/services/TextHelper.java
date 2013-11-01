package com.dusknode.services;

import java.util.ArrayList;
import java.util.LinkedList;
import com.sksamuel.diffpatch.DiffMatchPatch;
import com.sksamuel.diffpatch.DiffMatchPatch.Diff;

public class TextHelper {

  public static ArrayList<String> diff(String one, String two) {
    DiffMatchPatch helper = new DiffMatchPatch();
    LinkedList<Diff> diffs = helper.diff_main(one,two);
    ArrayList<String> strings = new ArrayList<String>();
    for (Diff d : diffs) {
      strings.add(d.toString());
    }
    return strings;
  }
}
