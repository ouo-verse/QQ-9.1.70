package qzone;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDoWhiteListRsp extends MessageMicro<QZIntimateSpaceWriter$StDoWhiteListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{null}, QZIntimateSpaceWriter$StDoWhiteListRsp.class);
    public final PBRepeatMessageField<QZIntimateSpaceWriter$WhiteListResult> results = PBField.initRepeatMessage(QZIntimateSpaceWriter$WhiteListResult.class);
}
