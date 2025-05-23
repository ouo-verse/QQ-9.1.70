package y52;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&J\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0012"}, d2 = {"Ly52/a;", "", "", VasWebviewConstants.KEY_PAGE_URL, "", "a", "f", "iconUrl", "e", "webUrl", "d", "", "wordToWebSearch", "g", "(Ljava/lang/Integer;)V", WadlProxyConsts.KEY_JUMP_URL, "b", "c", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {
    void a(@Nullable String pageUrl);

    void b(@Nullable String jumpUrl);

    @Nullable
    String c();

    void d(@Nullable String webUrl);

    void e(@Nullable String iconUrl);

    @Nullable
    String f();

    void g(@Nullable Integer wordToWebSearch);
}
