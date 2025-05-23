package v73;

import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lv73/a;", "", "", "b", "Ljava/lang/String;", "PRIVATE_BASE_PATH", "c", "EXPLORE_MATERIAL_PATH", "d", "EXPLORE_MATERIAL_DOWNLOAD_PATH", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f441215a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PRIVATE_BASE_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String EXPLORE_MATERIAL_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String EXPLORE_MATERIAL_DOWNLOAD_PATH;

    static {
        String str = BaseApplication.getContext().getFilesDir().getParent() + "/";
        PRIVATE_BASE_PATH = str;
        EXPLORE_MATERIAL_PATH = str + "app_lib/explore/";
        EXPLORE_MATERIAL_DOWNLOAD_PATH = str + "app_lib/explore/download/";
    }

    a() {
    }
}
