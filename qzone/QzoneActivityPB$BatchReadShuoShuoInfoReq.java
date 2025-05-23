package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$BatchReadShuoShuoInfoReq extends MessageMicro<QzoneActivityPB$BatchReadShuoShuoInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"filter", "shuoshuo_infos"}, new Object[]{null, null}, QzoneActivityPB$BatchReadShuoShuoInfoReq.class);
    public QzoneActivityPB$BatchReadFilter filter = new MessageMicro<QzoneActivityPB$BatchReadFilter>() { // from class: qzone.QzoneActivityPB$BatchReadFilter
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"bytes_res", "need_userinfo"}, new Object[]{0, 0}, QzoneActivityPB$BatchReadFilter.class);
        public final PBUInt32Field bytes_res = PBField.initUInt32(0);
        public final PBUInt32Field need_userinfo = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<QzoneActivityPB$ShuoShuoInfoReq> shuoshuo_infos = PBField.initRepeatMessage(QzoneActivityPB$ShuoShuoInfoReq.class);
}
