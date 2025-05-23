package uw4;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessUpdateParams;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface b {
    IBusinessCallback a(long j3);

    void b(@NonNull BusinessUpdateParams businessUpdateParams);

    void c(@NonNull BusinessUpdateParams businessUpdateParams, int i3, int i16, String str);

    void d(@NonNull BusinessUpdateParams businessUpdateParams, long j3, long j16, int i3);
}
