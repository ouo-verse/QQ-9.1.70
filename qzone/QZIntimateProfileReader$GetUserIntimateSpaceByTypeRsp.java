package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp extends MessageMicro<QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"spaceinfo"}, new Object[]{null}, QZIntimateProfileReader$GetUserIntimateSpaceByTypeRsp.class);
    public final PBRepeatMessageField<QZIntimateProfileReader$SpaceTypeWithJumpUrl> spaceinfo = PBField.initRepeatMessage(QZIntimateProfileReader$SpaceTypeWithJumpUrl.class);
}
