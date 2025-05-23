package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xefd$RptData extends MessageMicro<oidb_0xefd$RptData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"data_type", "at_data", "herf_data", "text_data"}, new Object[]{0, null, null, null}, oidb_0xefd$RptData.class);
    public final PBInt32Field data_type = PBField.initInt32(0);
    public oidb_0xefd$AtData at_data = new MessageMicro<oidb_0xefd$AtData>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$AtData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 42}, new String[]{"uid", "content"}, new Object[]{"", ""}, oidb_0xefd$AtData.class);
        public final PBStringField uid = PBField.initString("");
        public final PBStringField content = PBField.initString("");
    };
    public oidb_0xefd$HerfData herf_data = new MessageMicro<oidb_0xefd$HerfData>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$HerfData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"content", "url", "topic_id"}, new Object[]{"", "", ""}, oidb_0xefd$HerfData.class);
        public final PBStringField content = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBStringField topic_id = PBField.initString("");
    };
    public oidb_0xefd$TextData text_data = new MessageMicro<oidb_0xefd$TextData>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$TextData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"content"}, new Object[]{""}, oidb_0xefd$TextData.class);
        public final PBStringField content = PBField.initString("");
    };
}
