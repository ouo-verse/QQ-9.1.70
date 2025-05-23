package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe5c$ReqBody extends MessageMicro<cmd0xe5c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"type", "videoReqBody", "topicReqBody", "watch_word_req_body"}, new Object[]{0, null, null, null}, cmd0xe5c$ReqBody.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public cmd0xe5c$VideoReqBody videoReqBody = new MessageMicro<cmd0xe5c$VideoReqBody>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$VideoReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rowkey", "url", "topic_id"}, new Object[]{"", "", ""}, cmd0xe5c$VideoReqBody.class);
        public final PBStringField rowkey = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBStringField topic_id = PBField.initString("");
    };
    public cmd0xe5c$TopicReqBody topicReqBody = new MessageMicro<cmd0xe5c$TopicReqBody>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$TopicReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"topic_id", "url"}, new Object[]{"", ""}, cmd0xe5c$TopicReqBody.class);
        public final PBStringField topic_id = PBField.initString("");
        public final PBStringField url = PBField.initString("");
    };
    public cmd0xe5c$WatchWordReqBody watch_word_req_body = new MessageMicro<cmd0xe5c$WatchWordReqBody>() { // from class: tencent.im.oidb.cmd0xe5c.cmd0xe5c$WatchWordReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"watch_word"}, new Object[]{""}, cmd0xe5c$WatchWordReqBody.class);
        public final PBStringField watch_word = PBField.initString("");
    };
}
