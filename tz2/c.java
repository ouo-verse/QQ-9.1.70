package tz2;

import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Ltz2/c;", "", "", "adSequence", "", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "b", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface c {
    void a(long adSequence);

    void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg);
}
