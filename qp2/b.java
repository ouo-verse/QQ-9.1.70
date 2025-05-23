package qp2;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lqp2/b;", "", "", "getKeyword", "", "getStartSearchTimeStamps", "", "getQuerySource", "getTabMask", "getMiniAppSessionId", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    @NotNull
    String getKeyword();

    @NotNull
    String getMiniAppSessionId();

    int getQuerySource();

    long getStartSearchTimeStamps();

    int getTabMask();
}
