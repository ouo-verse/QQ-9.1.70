package ufo;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$BatchVerifyUgcRightRsp extends MessageMicro<UgcRight$BatchVerifyUgcRightRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{null}, UgcRight$BatchVerifyUgcRightRsp.class);
    public final PBRepeatMessageField<UgcRight$BatchVerifyResult> results = PBField.initRepeatMessage(UgcRight$BatchVerifyResult.class);
}
