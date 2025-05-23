package ufo;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$VerifyResult extends MessageMicro<UgcRight$VerifyResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{AppConstants.Key.KEY_QZONE_UGCKEY, "authResult"}, new Object[]{null, null}, UgcRight$VerifyResult.class);
    public UgcRight$UgcDataKey ugcKey = new UgcRight$UgcDataKey();
    public UgcRight$AuthResult authResult = new UgcRight$AuthResult();
}
