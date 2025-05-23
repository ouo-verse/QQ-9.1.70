package tencent.im.oidb.cmd0xeac;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeac$MsgElem extends MessageMicro<oidb_0xeac$MsgElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98, 106, 114, 122, 130, 138}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "text_msg", "face_msg", "image_msg", "group_file_msg", "share_msg", "rich_msg", "ark_msg"}, new Object[]{0, null, null, null, null, null, null, null}, oidb_0xeac$MsgElem.class);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public oidb_0xeac$TextMsg text_msg = new MessageMicro<oidb_0xeac$TextMsg>() { // from class: tencent.im.oidb.cmd0xeac.oidb_0xeac$TextMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xeac$TextMsg.class);
        public final PBBytesField str = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0xeac$FaceMsg face_msg = new MessageMicro<oidb_0xeac$FaceMsg>() { // from class: tencent.im.oidb.cmd0xeac.oidb_0xeac$FaceMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"index", "text"}, new Object[]{0, ""}, oidb_0xeac$FaceMsg.class);
        public final PBUInt32Field index = PBField.initUInt32(0);
        public final PBStringField text = PBField.initString("");
    };
    public oidb_0xeac$ImageMsg image_msg = new MessageMicro<oidb_0xeac$ImageMsg>() { // from class: tencent.im.oidb.cmd0xeac.oidb_0xeac$ImageMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 808, 816, 824, 834, 1610, 1618, 1626}, new String[]{"md5", "uuid", "img_type", "file_size", "width", "height", "file_id", "server_ip", "server_port", "str_file_path", FacadeCacheData.THUMB_URL, "original_url", "resave_url"}, new Object[]{"", "", 0, 0, 0, 0, 0, 0, 0, "", "", "", ""}, oidb_0xeac$ImageMsg.class);
        public final PBStringField md5 = PBField.initString("");
        public final PBStringField uuid = PBField.initString("");
        public final PBUInt32Field img_type = PBField.initUInt32(0);
        public final PBUInt32Field file_size = PBField.initUInt32(0);
        public final PBUInt32Field width = PBField.initUInt32(0);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBUInt32Field file_id = PBField.initUInt32(0);
        public final PBUInt32Field server_ip = PBField.initUInt32(0);
        public final PBUInt32Field server_port = PBField.initUInt32(0);
        public final PBStringField str_file_path = PBField.initString("");
        public final PBStringField thumb_url = PBField.initString("");
        public final PBStringField original_url = PBField.initString("");
        public final PBStringField resave_url = PBField.initString("");
    };
    public oidb_0xeac$GroupFileMsg group_file_msg = new MessageMicro<oidb_0xeac$GroupFileMsg>() { // from class: tencent.im.oidb.cmd0xeac.oidb_0xeac$GroupFileMsg
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field bus_id;
        public final PBUInt64Field dead_time;
        public final PBBytesField ext;
        public final PBStringField file_id;
        public final PBBytesField file_md5;
        public final PBBytesField file_name;
        public final PBBytesField file_sha1;
        public final PBUInt64Field file_size;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 58, 66}, new String[]{"file_name", "bus_id", "file_id", "file_size", "dead_time", "file_sha1", "ext", "file_md5"}, new Object[]{byteStringMicro, 0, "", 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xeac$GroupFileMsg.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.file_name = PBField.initBytes(byteStringMicro);
            this.bus_id = PBField.initUInt32(0);
            this.file_id = PBField.initString("");
            this.file_size = PBField.initUInt64(0L);
            this.dead_time = PBField.initUInt64(0L);
            this.file_sha1 = PBField.initBytes(byteStringMicro);
            this.ext = PBField.initBytes(byteStringMicro);
            this.file_md5 = PBField.initBytes(byteStringMicro);
        }
    };
    public oidb_0xeac$ShareMsg share_msg = new MessageMicro<oidb_0xeac$ShareMsg>() { // from class: tencent.im.oidb.cmd0xeac.oidb_0xeac$ShareMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"type", "title", "summary", "brief", "url", "picture_url", "action", "source", AppConstants.Key.SHARE_SOURCE_URL}, new Object[]{"", "", "", "", "", "", "", "", ""}, oidb_0xeac$ShareMsg.class);
        public final PBStringField type = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField summary = PBField.initString("");
        public final PBStringField brief = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBStringField picture_url = PBField.initString("");
        public final PBStringField action = PBField.initString("");
        public final PBStringField source = PBField.initString("");
        public final PBStringField source_url = PBField.initString("");
    };
    public oidb_0xeac$RichMsg rich_msg = new MessageMicro<oidb_0xeac$RichMsg>() { // from class: tencent.im.oidb.cmd0xeac.oidb_0xeac$RichMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"service_id", "xml", "long_msg_resid"}, new Object[]{0, "", ""}, oidb_0xeac$RichMsg.class);
        public final PBUInt32Field service_id = PBField.initUInt32(0);
        public final PBStringField xml = PBField.initString("");
        public final PBStringField long_msg_resid = PBField.initString("");
    };
    public oidb_0xeac$ArkMsg ark_msg = new MessageMicro<oidb_0xeac$ArkMsg>() { // from class: tencent.im.oidb.cmd0xeac.oidb_0xeac$ArkMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_name", ark.ARKMETADATA_JSON}, new Object[]{"", ""}, oidb_0xeac$ArkMsg.class);
        public final PBStringField app_name = PBField.initString("");
        public final PBStringField json = PBField.initString("");
    };
}
