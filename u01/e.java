package u01;

import android.app.Application;
import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.ditto.shell.LayoutAttrDefine;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lu01/e;", "Lu01/d;", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "Landroid/content/ContentResolver;", "contentResolver", "Ljava/io/InputStream;", "b", "contactUri", "c", "a", "Landroid/content/ContentResolver;", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "d", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class e extends d {

    /* renamed from: c, reason: collision with root package name */
    private static final UriMatcher f438017c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ContentResolver contentResolver;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Uri uri;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f438017c = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public e(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "RFWApplication.getApplication().contentResolver");
        this.contentResolver = contentResolver;
    }

    private final InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f438017c.match(uri);
        if (match != -1) {
            if (match != 1) {
                if (match != 2) {
                    if (match != 3) {
                        if (match != 4) {
                            if (match != 5) {
                                return contentResolver.openInputStream(uri);
                            }
                        }
                    } else {
                        return c(contentResolver, uri);
                    }
                }
            }
            Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
            if (lookupContact != null) {
                return c(contentResolver, lookupContact);
            }
            throw new FileNotFoundException("Contact cannot be found");
        }
        return contentResolver.openInputStream(uri);
    }

    private final InputStream c(ContentResolver contentResolver, Uri contactUri) {
        InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, contactUri, true);
        Intrinsics.checkNotNullExpressionValue(openContactPhotoInputStream, "ContactsContract.Contact\u2026preferHighres*/\n        )");
        return openContactPhotoInputStream;
    }

    @Override // u01.d
    @NotNull
    public InputStream a() throws IOException {
        InputStream b16 = b(this.uri, this.contentResolver);
        if (b16 != null) {
            return b16;
        }
        throw new IOException("InputStream = null");
    }
}
