package letsdev.common.util.thread;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class ThreadUtils {

    private ThreadUtils() {}

    /**
     * @return call-stack trace as a string
     */
    public static String callStack() {
        return callStack(1);
    }

    /**
     * print call-stack trace
     */
    public static void printCallStack() {
        System.out.println(callStack(1));
    }

    /**
     * print call-stack trace
     */
    public static void printCallStack(PrintStream source) {
        source.println(callStack(1));
    }

    /**
     * print call-stack trace
     */
    public static void printCallStack(PrintWriter source) {
        source.println(callStack(1));
    }

    private static String callStack(int offset) {
        StringBuilder builder = new StringBuilder("call-stack trace");
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();

        if (offset < -2) {
            offset = -2;
        }

        // removal(skipped):
        //  Thread.currentThread().getStackTrace()
        //  ThreadUtil.getCallStack()
        //  public methods of ThreadUtil
        for (int i = 2 + offset; i < elements.length; i++) {
            StackTraceElement s = elements[i];
            builder.append("\n\tat ");
            builder.append(s.getClassName());
            builder.append(".");
            builder.append(s.getMethodName());
            builder.append("(");
            builder.append(s.getFileName());
            builder.append(":");
            builder.append(s.getLineNumber());
            builder.append(")");
        }

        return builder.toString();
    }
}