package tencent.im.groupvideo.memposinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class memposinfo$AccountExtInfoList extends MessageMicro<memposinfo$AccountExtInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_account_ext_info"}, new Object[]{null}, memposinfo$AccountExtInfoList.class);
    public final PBRepeatMessageField<memposinfo$AccountExtInfo> msg_account_ext_info = PBField.initRepeatMessage(memposinfo$AccountExtInfo.class);
}
