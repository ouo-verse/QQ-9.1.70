package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetSpaceCountRsp extends MessageMicro<QZIntimateSpaceAlbum$GetSpaceCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"count_info"}, new Object[]{null}, QZIntimateSpaceAlbum$GetSpaceCountRsp.class);
    public final PBRepeatMessageField<QZIntimateSpaceAlbum$SpaceCountInfo> count_info = PBField.initRepeatMessage(QZIntimateSpaceAlbum$SpaceCountInfo.class);
}
