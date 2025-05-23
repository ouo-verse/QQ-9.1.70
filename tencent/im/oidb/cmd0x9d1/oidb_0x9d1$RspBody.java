package tencent.im.oidb.cmd0x9d1;

import appoint.define.appoint_define$UserFeed;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9d1$RspBody extends MessageMicro<oidb_0x9d1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"str_error_tips", "msg_feeds", "uint64_tinyid"}, new Object[]{"", null, 0L}, oidb_0x9d1$RspBody.class);
    public final PBStringField str_error_tips = PBField.initString("");
    public appoint_define$UserFeed msg_feeds = new MessageMicro<appoint_define$UserFeed>() { // from class: appoint.define.appoint_define$UserFeed
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"msg_user_info", "msg_feed_info", "uint32_owner_flag", "msg_activity_info"}, new Object[]{null, null, 0, null}, appoint_define$UserFeed.class);
        public appoint_define$PublisherInfo msg_user_info = new appoint_define$PublisherInfo();
        public appoint_define$FeedInfo msg_feed_info = new appoint_define$FeedInfo();
        public final PBUInt32Field uint32_owner_flag = PBField.initUInt32(0);
        public appoint_define$ActivityInfo msg_activity_info = new MessageMicro<appoint_define$ActivityInfo>() { // from class: appoint.define.appoint_define$ActivityInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 64, 72, 80, 90, 96}, new String[]{"id", "name", "cover", "url", "start_time", "end_time", "loc_name", "enroll", "create_uin", AlbumCacheData.CREATE_TIME, "organizer_info", "uint64_flag"}, new Object[]{"", "", "", "", 0, 0, "", 0L, 0L, 0, null, 0L}, appoint_define$ActivityInfo.class);

            /* renamed from: id, reason: collision with root package name */
            public final PBStringField f26705id = PBField.initString("");
            public final PBStringField name = PBField.initString("");
            public final PBStringField cover = PBField.initString("");
            public final PBStringField url = PBField.initString("");
            public final PBUInt32Field start_time = PBField.initUInt32(0);
            public final PBUInt32Field end_time = PBField.initUInt32(0);
            public final PBStringField loc_name = PBField.initString("");
            public final PBUInt64Field enroll = PBField.initUInt64(0);
            public final PBUInt64Field create_uin = PBField.initUInt64(0);
            public final PBUInt32Field create_time = PBField.initUInt32(0);
            public appoint_define$OrganizerInfo organizer_info = new MessageMicro<appoint_define$OrganizerInfo>() { // from class: appoint.define.appoint_define$OrganizerInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"host_name", "host_url", "host_cover"}, new Object[]{"", "", ""}, appoint_define$OrganizerInfo.class);
                public final PBStringField host_name = PBField.initString("");
                public final PBStringField host_url = PBField.initString("");
                public final PBStringField host_cover = PBField.initString("");
            };
            public final PBUInt64Field uint64_flag = PBField.initUInt64(0);
        };
    };
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
}
