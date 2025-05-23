package tencent.im.oidb.cmd0xe5c;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe5c$RspBody extends MessageMicro<cmd0xe5c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"type", "video_rsp_body", "topic_rsp_body", "watch_rsp_body"}, new Object[]{0, null, null, null}, cmd0xe5c$RspBody.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public cmd0xe5c$VideoRspBody video_rsp_body = new MessageMicro<cmd0xe5c$VideoRspBody>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$VideoRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"url", "watch_word", "is_open"}, new Object[]{"", "", Boolean.FALSE}, cmd0xe5c$VideoRspBody.class);
        public final PBStringField url = PBField.initString("");
        public final PBStringField watch_word = PBField.initString("");
        public final PBBoolField is_open = PBField.initBool(false);
    };
    public cmd0xe5c$TopicRspBody topic_rsp_body = new MessageMicro<cmd0xe5c$TopicRspBody>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$TopicRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"url", "watch_word", "is_open"}, new Object[]{"", "", Boolean.FALSE}, cmd0xe5c$TopicRspBody.class);
        public final PBStringField url = PBField.initString("");
        public final PBStringField watch_word = PBField.initString("");
        public final PBBoolField is_open = PBField.initBool(false);
    };
    public cmd0xe5c$WatchRspBody watch_rsp_body = new MessageMicro<cmd0xe5c$WatchRspBody>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$WatchRspBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBBoolField is_expired = PBField.initBool(false);
        public final PBBoolField is_deleted = PBField.initBool(false);
        public cmd0xe5c$UserInfo from = new MessageMicro<cmd0xe5c$UserInfo>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$UserInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"username", "uin"}, new Object[]{"", 0L}, cmd0xe5c$UserInfo.class);
            public final PBStringField username = PBField.initString("");
            public final PBUInt64Field uin = PBField.initUInt64(0);
        };
        public cmd0xe5c$VideoInfo video = new MessageMicro<cmd0xe5c$VideoInfo>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$VideoInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"cover", "title", "type", QZoneDTLoginReporter.SCHEMA, "rowkey"}, new Object[]{"", "", 0, "", ""}, cmd0xe5c$VideoInfo.class);
            public final PBStringField cover = PBField.initString("");
            public final PBStringField title = PBField.initString("");
            public final PBUInt32Field type = PBField.initUInt32(0);
            public final PBStringField schema = PBField.initString("");
            public final PBStringField rowkey = PBField.initString("");
        };
        public cmd0xe5c$TopicInfo topic = new MessageMicro<cmd0xe5c$TopicInfo>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$TopicInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"icon", "title", "topic_id"}, new Object[]{"", "", ""}, cmd0xe5c$TopicInfo.class);
            public final PBStringField icon = PBField.initString("");
            public final PBStringField title = PBField.initString("");
            public final PBStringField topic_id = PBField.initString("");
        };

        static {
            String[] strArr = {"type", "is_expired", PictureConst.PHOTO_DELETED, "from", "video", "topic"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, strArr, new Object[]{0, bool, bool, null, null, null}, cmd0xe5c$WatchRspBody.class);
        }
    };
}
