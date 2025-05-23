package uy3;

import com.tencent.commonsdk.zip.QZipFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c extends QZipFile {

    /* renamed from: d, reason: collision with root package name */
    protected File f440622d;

    /* renamed from: e, reason: collision with root package name */
    protected ZipFile f440623e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f440624f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, ZipEntry> f440625h;

    public c(File file, File file2, ZipFile zipFile) throws IOException {
        super(file);
        this.f440622d = file2;
        this.f440623e = zipFile;
        this.f440625h = new HashMap<>();
    }

    public synchronized boolean a() throws IOException {
        if (this.f440624f) {
            return false;
        }
        ZipFile zipFile = this.f440623e;
        if (zipFile != null) {
            zipFile.close();
            this.f440623e = null;
        }
        this.f440624f = true;
        return true;
    }

    @Override // java.util.zip.ZipFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        ZipFile zipFile = this.f440623e;
        if (zipFile != null) {
            zipFile.close();
        }
        this.f440625h.clear();
    }

    public synchronized void d() {
        if (this.f440624f) {
            return;
        }
        try {
            try {
                Field declaredField = this.f440623e.getClass().getDeclaredField("entries");
                declaredField.setAccessible(true);
                Iterator it = ((LinkedHashMap) declaredField.get(this.f440623e)).entrySet().iterator();
                while (it.hasNext()) {
                    if (!((String) ((Map.Entry) it.next()).getKey()).endsWith(".so")) {
                        it.remove();
                    }
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            }
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
        }
    }

    @Override // java.util.zip.ZipFile
    public synchronized Enumeration<? extends ZipEntry> entries() {
        if (this.f440624f) {
            try {
                this.f440623e = new QZipFile(this.f440622d);
                this.f440624f = false;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return this.f440623e.entries();
    }

    @Override // java.util.zip.ZipFile
    public synchronized ZipEntry getEntry(String str) {
        ZipEntry zipEntry = this.f440625h.get(str);
        if (zipEntry != null) {
            return zipEntry;
        }
        if (this.f440624f) {
            try {
                this.f440623e = new QZipFile(this.f440622d);
                this.f440624f = false;
            } catch (IOException unused) {
                return null;
            }
        }
        ZipEntry entry = this.f440623e.getEntry(str);
        this.f440625h.put(str, entry);
        return entry;
    }

    @Override // com.tencent.commonsdk.zip.QZipFile, java.util.zip.ZipFile
    public synchronized InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        if (this.f440624f) {
            this.f440623e = new QZipFile(this.f440622d);
            this.f440624f = false;
        }
        return this.f440623e.getInputStream(zipEntry);
    }

    @Override // java.util.zip.ZipFile
    public String getName() {
        if (this.f440624f) {
            try {
                this.f440623e = new QZipFile(this.f440622d);
                this.f440624f = false;
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f440623e.getName();
    }

    @Override // java.util.zip.ZipFile
    public synchronized int size() {
        if (this.f440624f) {
            try {
                this.f440623e = new QZipFile(this.f440622d);
                this.f440624f = false;
            } catch (IOException unused) {
                return 0;
            }
        }
        return this.f440623e.size();
    }
}
