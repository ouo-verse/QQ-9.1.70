package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$GetTagListRsp extends MessageMicro<UgcRight$GetTagListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"taglist"}, new Object[]{null}, UgcRight$GetTagListRsp.class);
    public final PBRepeatMessageField<UgcRight$TagInfo> taglist = PBField.initRepeatMessage(UgcRight$TagInfo.class);
}
