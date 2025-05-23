package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$BatchReadShuoShuoInfoRsp extends MessageMicro<QzoneActivityPB$BatchReadShuoShuoInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"shuoshuo_infos"}, new Object[]{null}, QzoneActivityPB$BatchReadShuoShuoInfoRsp.class);
    public final PBRepeatMessageField<QzoneActivityPB$ShuoShuoInfo> shuoshuo_infos = PBField.initRepeatMessage(QzoneActivityPB$ShuoShuoInfo.class);
}
