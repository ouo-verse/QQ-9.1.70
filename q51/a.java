package q51;

import com.tencent.minibox.loader.zip.QZipIOException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends ZipFile {
    public a(File file) throws ZipException, IOException {
        super(file);
    }

    @Override // java.util.zip.ZipFile
    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        if (!QZipIOException.isInvalidEntry(zipEntry)) {
            return super.getInputStream(zipEntry);
        }
        throw new QZipIOException();
    }

    public a(String str) throws IOException {
        super(str);
    }
}
