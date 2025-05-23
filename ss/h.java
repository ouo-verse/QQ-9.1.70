package ss;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.tencent.biz.richframework.util.ByteArrayPool;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.PermissionUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J,\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0018"}, d2 = {"Lss/h;", "", "Ljava/io/File;", "originPicFile", "", "targetFileName", "Lss/e;", "callback", "Landroid/content/Context;", "context", "", "f", "path", "e", "", "d", "Landroid/net/Uri;", "mediaUri", "mediaFile", "", "i", "j", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f434426a = new h();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"ss/h$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f434427a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f434428b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f434429c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f434430d;

        a(File file, String str, e eVar, Context context) {
            this.f434427a = file;
            this.f434428b = str;
            this.f434429c = eVar;
            this.f434430d = context;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("SaveMediaUtil", 1, "Permission granted");
            h.f434426a.f(this.f434427a, this.f434428b, this.f434429c, this.f434430d);
        }
    }

    h() {
    }

    private final int d(String path) {
        int readOrientation = JpegExifReader.readOrientation(path);
        if (readOrientation == 3) {
            return 180;
        }
        if (readOrientation != 6) {
            return readOrientation != 8 ? 0 : 270;
        }
        return 90;
    }

    private final String e(String path) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(path);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final File originPicFile, final String targetFileName, final e callback, final Context context) {
        ThreadManagerV2.excute(new Runnable() { // from class: ss.f
            @Override // java.lang.Runnable
            public final void run() {
                h.g(originPicFile, targetFileName, callback, context);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g(File originPicFile, String str, e eVar, Context context) {
        boolean contains$default;
        boolean contains$default2;
        Uri uri;
        Object m476constructorimpl;
        char c16;
        Uri insert;
        String targetFileName = str;
        Intrinsics.checkNotNullParameter(originPicFile, "$originPicFile");
        Intrinsics.checkNotNullParameter(targetFileName, "$targetFileName");
        Intrinsics.checkNotNullParameter(context, "$context");
        String absolutePath = originPicFile.getAbsolutePath();
        QLog.d("SaveMediaUtil", 1, "Begin : originFilePath exist: " + originPicFile.exists() + " ");
        String name = new File(targetFileName).getName();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            targetFileName = AppConstants.SDCARD_IMG_CAMERA + name;
        }
        String str2 = targetFileName;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(absolutePath, options);
        String str3 = options.outMimeType;
        if (str3 == null && (str3 = f434426a.e(absolutePath)) == null) {
            str3 = "UNKNOWN MIME";
        }
        String str4 = str3;
        QLog.d("SaveMediaUtil", 1, "originFilePath: " + absolutePath + ", finalSavedPath: " + str2 + ", mimeType: " + str4);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) "video", false, 2, (Object) null);
        if (contains$default) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) "image", false, 2, (Object) null);
            if (!contains$default2) {
                QLog.e("SaveMediaUtil", 1, "UNKNOWN MIME!");
                if (eVar != null) {
                    eVar.onResult(false, str2);
                    return;
                }
                return;
            }
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        QLog.d("SaveMediaUtil", 1, "before cV: originFilePath exist: " + originPicFile.exists() + " ");
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", name);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, name);
        contentValues.put("_size", Long.valueOf(originPicFile.length()));
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, str4);
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        if (Intrinsics.areEqual(uri, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)) {
            contentValues.put("description", name);
        } else if (Intrinsics.areEqual(uri, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) {
            contentValues.put("description", name);
            contentValues.put("orientation", Integer.valueOf(f434426a.d(absolutePath)));
        }
        if (i3 < 29) {
            contentValues.put("_data", str2);
        } else {
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            String str5 = Environment.DIRECTORY_DCIM;
            String str6 = File.separator;
            contentValues.put("relative_path", str5 + str6 + "Camera" + str6);
        }
        h hVar = f434426a;
        try {
            Result.Companion companion = Result.INSTANCE;
            insert = context.getContentResolver().insert(uri, contentValues);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (insert != null) {
            QLog.e("SaveMediaUtil", 1, "savePicToGallery uri:" + insert);
            File file = new File(absolutePath);
            if (file.exists()) {
                QLog.d("SaveMediaUtil", 1, "savePicToGallery originFile:" + file + " is exist");
            } else {
                QLog.e("SaveMediaUtil", 1, "savePicToGallery originFile:" + file + " is NOT exist");
            }
            if (hVar.i(context, insert, file)) {
                m476constructorimpl = Result.m476constructorimpl(insert);
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    QLog.e("SaveMediaUtil", 1, "savePicToGallery Error:" + m479exceptionOrNullimpl);
                    if (eVar != null) {
                        c16 = 0;
                        eVar.onResult(false, str2);
                        if (Result.m483isSuccessimpl(m476constructorimpl)) {
                            return;
                        }
                        Context applicationContext = context.getApplicationContext();
                        String[] strArr = new String[1];
                        strArr[c16] = str2;
                        String[] strArr2 = new String[1];
                        strArr2[c16] = str4;
                        MediaScannerConnection.scanFile(applicationContext, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: ss.g
                            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                            public final void onScanCompleted(String str7, Uri uri2) {
                                h.h(str7, uri2);
                            }
                        });
                        if (eVar != null) {
                            eVar.onResult(true, str2);
                            return;
                        }
                        return;
                    }
                }
                c16 = 0;
                if (Result.m483isSuccessimpl(m476constructorimpl)) {
                }
            } else {
                throw new RuntimeException("saveFileToMediaUri\u5f02\u5e38");
            }
        } else {
            throw new RuntimeException("saveFileToMediaUri\u5f02\u5e38 uri\u4e3anull");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str, Uri uri) {
        QLog.i("SaveMediaUtil", 1, "ExternalStorage Scanned " + str + ": uri=" + uri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r12v23, types: [java.io.Closeable[]] */
    private final boolean i(Context context, Uri mediaUri, File mediaFile) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2;
        if (mediaUri == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                context = context.getContentResolver().openFileDescriptor(mediaUri, "rw");
                if (context == 0) {
                    RFWIOUtil.flushAll(null);
                    RFWIOUtil.closeAll(new Closeable[]{0, 0, context});
                    return false;
                }
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(context.getFileDescriptor());
                    try {
                        fileInputStream = new FileInputStream(mediaFile);
                    } catch (IOException e16) {
                        e = e16;
                        fileInputStream = null;
                    } catch (SecurityException e17) {
                        e = e17;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                    }
                    try {
                        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                        while (true) {
                            int read = fileInputStream.read(buf);
                            if (read != -1) {
                                fileOutputStream2.write(buf, 0, read);
                            } else {
                                ByteArrayPool.getGenericInstance().returnBuf(buf);
                                RFWIOUtil.flushAll(fileOutputStream2);
                                RFWIOUtil.closeAll(new Closeable[]{fileInputStream, fileOutputStream2, context});
                                return true;
                            }
                        }
                    } catch (IOException e18) {
                        e = e18;
                        fileOutputStream = fileOutputStream2;
                        closeable2 = context;
                        QLog.e("SaveMediaUtil", 1, "saveFileToMediaUri:" + e);
                        RFWIOUtil.flushAll(fileOutputStream);
                        RFWIOUtil.closeAll(fileInputStream, fileOutputStream, closeable2);
                        context = closeable2;
                        return false;
                    } catch (SecurityException e19) {
                        e = e19;
                        fileOutputStream = fileOutputStream2;
                        closeable = context;
                        QLog.e("SaveMediaUtil", 1, "saveFileToMediaUri:" + e);
                        RFWIOUtil.flushAll(fileOutputStream);
                        RFWIOUtil.closeAll(fileInputStream, fileOutputStream, closeable);
                        context = closeable;
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream = fileOutputStream2;
                        RFWIOUtil.flushAll(fileOutputStream);
                        RFWIOUtil.closeAll(new Closeable[]{fileInputStream, fileOutputStream, context});
                        throw th;
                    }
                } catch (IOException e26) {
                    e = e26;
                    fileInputStream = null;
                    closeable2 = context;
                } catch (SecurityException e27) {
                    e = e27;
                    fileInputStream = null;
                    closeable = context;
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = null;
                }
            } catch (IOException e28) {
                e = e28;
                closeable2 = null;
                fileInputStream = null;
            } catch (SecurityException e29) {
                e = e29;
                closeable = null;
                fileInputStream = null;
            } catch (Throwable th8) {
                th = th8;
                context = 0;
                fileInputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public final void j(Context context, File originPicFile, String targetFileName, e callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originPicFile, "originPicFile");
        Intrinsics.checkNotNullParameter(targetFileName, "targetFileName");
        if (!PermissionUtil.isHasStoragePermission(context) && (context instanceof Activity)) {
            QQPermissionFactory.getQQPermission((Activity) context, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(originPicFile, targetFileName, callback, context));
        } else {
            QLog.d("SaveMediaUtil", 1, "Permission granted");
            f(originPicFile, targetFileName, callback, context);
        }
    }
}
