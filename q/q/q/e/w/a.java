package q.q.q.e.w;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import q.q.q.e.w.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public class a implements c.a, Runnable {

    /* renamed from: h, reason: collision with root package name */
    private static volatile a f428111h;

    /* renamed from: d, reason: collision with root package name */
    private final BlockingQueue<String> f428112d = new LinkedBlockingQueue();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f428113e = false;

    /* renamed from: f, reason: collision with root package name */
    private File f428114f;

    a() {
    }

    public static a e() {
        if (f428111h == null) {
            synchronized (a.class) {
                if (f428111h == null) {
                    f428111h = new a();
                }
            }
        }
        return f428111h;
    }

    private static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.d("FileLogger", "Exception when closing the closeable.");
            }
        }
    }

    private void h(String str) {
        if (this.f428114f.length() + str.length() > 3145728) {
            if (!this.f428114f.renameTo(new File(this.f428114f.getPath() + ".bak"))) {
                Log.w("FileLogger", "Failed to backup the log file.");
            }
        }
    }

    private void i(String str) {
        BufferedOutputStream bufferedOutputStream;
        OutputStreamWriter outputStreamWriter;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.f428114f, true);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                    } catch (FileNotFoundException unused) {
                        outputStreamWriter = null;
                    } catch (IOException unused2) {
                        outputStreamWriter = null;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStreamWriter = null;
                    }
                } catch (FileNotFoundException unused3) {
                    bufferedOutputStream = null;
                    outputStreamWriter = null;
                } catch (IOException unused4) {
                    bufferedOutputStream = null;
                    outputStreamWriter = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                    outputStreamWriter = null;
                }
            } catch (FileNotFoundException unused5) {
                bufferedOutputStream = null;
                outputStreamWriter = null;
            } catch (IOException unused6) {
                bufferedOutputStream = null;
                outputStreamWriter = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedOutputStream = null;
                outputStreamWriter = null;
            }
            try {
                outputStreamWriter.write(str);
                outputStreamWriter.flush();
            } catch (FileNotFoundException unused7) {
                fileOutputStream2 = fileOutputStream;
                Log.d("FileLogger", "Exception when writing the log file.");
                fileOutputStream = fileOutputStream2;
                f(outputStreamWriter);
                f(bufferedOutputStream);
                f(fileOutputStream);
            } catch (IOException unused8) {
                fileOutputStream2 = fileOutputStream;
                Log.d("FileLogger", "Exception when writing the log file.");
                fileOutputStream = fileOutputStream2;
                f(outputStreamWriter);
                f(bufferedOutputStream);
                f(fileOutputStream);
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream2 = fileOutputStream;
                f(outputStreamWriter);
                f(bufferedOutputStream);
                f(fileOutputStream2);
                throw th;
            }
            f(outputStreamWriter);
            f(bufferedOutputStream);
            f(fileOutputStream);
        } catch (Throwable th9) {
            th = th9;
        }
    }

    @Override // q.q.q.e.w.c.a
    public void a(String str) {
        if (str != null && this.f428114f != null && !this.f428112d.offer(str)) {
            Log.w("FileLogger", "write offer failed");
        }
    }

    public void g(File file) {
        if (file == null) {
            Log.w("FileLogger", "Invalid argument.");
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.w("FileLogger", "logDir is null");
            return;
        }
        if (!parentFile.mkdirs()) {
            Log.w("FileLogger", "Failed to create the log dir or has created.");
        }
        if (!parentFile.isDirectory()) {
            Log.w("FileLogger", "Failed to create the log dir.");
        } else {
            this.f428114f = file;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f428114f != null) {
            while (this.f428113e) {
                try {
                    String poll = this.f428112d.poll(1L, TimeUnit.SECONDS);
                    if (poll != null) {
                        h(poll);
                        i(poll);
                    }
                } catch (InterruptedException unused) {
                    Log.d("FileLogger", "run InterruptedException.");
                } catch (Exception unused2) {
                    Log.d("FileLogger", "run Exception.");
                }
            }
        }
        Log.i("FileLogger", "The log logger is closed.");
    }
}
