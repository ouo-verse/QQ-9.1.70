package xc4;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.state.SquarePublicActivity;
import com.tencent.zplan.meme.model.MemeResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J=\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u0017\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u001b"}, d2 = {"Lxc4/c;", "", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "a", "Landroid/content/Context;", "context", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "selection", "", "selectionArgs", "b", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "", "e", "d", "f", "", "list", "", "g", "c", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f447785a = new c();

    c() {
    }

    private final String a(String parent, MemeResult result) {
        String str;
        int i3 = b.f447784a[result.getAction().getMode().ordinal()];
        if (i3 == 1) {
            str = ".mp4";
        } else if (i3 != 2) {
            str = ".0";
        } else {
            str = ".png";
        }
        String str2 = parent + '/' + result.getRecordKey() + str;
        a.f447783a.b(result.getRecordPath(), str2);
        return str2;
    }

    private final String b(Context context, Uri uri, String selection, String[] selectionArgs) {
        String[] strArr = {"_data"};
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNull(uri);
            Cursor query = ContactsMonitor.query(contentResolver, uri, strArr, selection, selectionArgs, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        query.close();
                        return string;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final boolean d(Uri uri) {
        return Intrinsics.areEqual("com.android.providers.downloads.documents", uri.getAuthority());
    }

    private final boolean e(Uri uri) {
        return Intrinsics.areEqual("com.android.externalstorage.documents", uri.getAuthority());
    }

    private final boolean f(Uri uri) {
        return Intrinsics.areEqual("com.android.providers.media.documents", uri.getAuthority());
    }

    public final String c(Context context, Uri uri) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uri2 = null;
        if (uri == null) {
            return null;
        }
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            equals = StringsKt__StringsJVMKt.equals("content", uri.getScheme(), true);
            if (!equals) {
                equals2 = StringsKt__StringsJVMKt.equals("file", uri.getScheme(), true);
                if (equals2) {
                    return uri.getPath();
                }
            } else {
                return b(context, uri, null, null);
            }
        } else if (e(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            Intrinsics.checkNotNullExpressionValue(documentId, "DocumentsContract.getDocumentId(uri)");
            Object[] array = new Regex(":").split(documentId, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                equals3 = StringsKt__StringsJVMKt.equals("primary", strArr[0], true);
                if (equals3) {
                    return Environment.getExternalStorageDirectory().toString() + "/" + strArr[1];
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            if (d(uri)) {
                String documentId2 = DocumentsContract.getDocumentId(uri);
                Intrinsics.checkNotNullExpressionValue(documentId2, "DocumentsContract.getDocumentId(uri)");
                Uri parse = Uri.parse("content://downloads/public_downloads");
                Long valueOf = Long.valueOf(documentId2);
                Intrinsics.checkNotNullExpressionValue(valueOf, "java.lang.Long.valueOf(id)");
                Uri withAppendedId = ContentUris.withAppendedId(parse, valueOf.longValue());
                Intrinsics.checkNotNullExpressionValue(withAppendedId, "ContentUris.withAppended\u2026eOf(id)\n                )");
                return b(context, withAppendedId, null, null);
            }
            if (f(uri)) {
                String documentId3 = DocumentsContract.getDocumentId(uri);
                Intrinsics.checkNotNullExpressionValue(documentId3, "DocumentsContract.getDocumentId(uri)");
                Object[] array2 = new Regex(":").split(documentId3, 0).toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr2 = (String[]) array2;
                    String str = strArr2[0];
                    int hashCode = str.hashCode();
                    if (hashCode != 93166550) {
                        if (hashCode != 100313435) {
                            if (hashCode == 112202875 && str.equals("video")) {
                                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            }
                        } else if (str.equals("image")) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        }
                    } else if (str.equals("audio")) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return b(context, uri2, "_id=?", new String[]{strArr2[1]});
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return null;
    }

    public final void g(Context context, List<MemeResult> list) {
        Object first;
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        File[] externalMediaDirs = context.getExternalMediaDirs();
        Intrinsics.checkNotNullExpressionValue(externalMediaDirs, "context.externalMediaDirs");
        first = ArraysKt___ArraysKt.first(externalMediaDirs);
        Intrinsics.checkNotNullExpressionValue(first, "context.externalMediaDirs.first()");
        String dstPath = ((File) first).getAbsolutePath();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (MemeResult memeResult : list) {
            if (!TextUtils.isEmpty(memeResult.getRecordPath())) {
                c cVar = f447785a;
                Intrinsics.checkNotNullExpressionValue(dstPath, "dstPath");
                arrayList.add(Uri.fromFile(new File(cVar.a(dstPath, memeResult))));
            }
        }
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        intent2.setFlags(268435456);
        intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent2.setType("*/*");
        SquarePublicActivity squarePublicActivity = (SquarePublicActivity) (!(context instanceof SquarePublicActivity) ? null : context);
        if (squarePublicActivity != null && (intent = squarePublicActivity.getIntent()) != null) {
            intent.putExtra("big_brother_source_key", "biz_src_unknown");
        }
        context.startActivity(Intent.createChooser(intent2, "\u5206\u4eab"));
    }
}
