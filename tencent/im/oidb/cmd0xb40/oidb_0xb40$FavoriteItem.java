package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb40$FavoriteItem extends MessageMicro<oidb_0xb40$FavoriteItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_cid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public oidb_0xb40$Author msg_author = new MessageMicro<oidb_0xb40$Author>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$Author
        public static final int Email = 4;
        public static final int Group = 2;
        public static final int Phone = 5;
        public static final int TempTeam = 3;
        public static final int Uin = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_group_name;
        public final PBBytesField bytes_str_id;
        public final PBUInt64Field uint64_group_id;
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_num_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uint32_type", "uint64_num_id", "bytes_str_id", "uint64_group_id", "bytes_group_name"}, new Object[]{0, 0L, byteStringMicro, 0L, byteStringMicro}, oidb_0xb40$Author.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_str_id = PBField.initBytes(byteStringMicro);
            this.uint64_group_id = PBField.initUInt64(0L);
            this.bytes_group_name = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBUInt64Field uint64_favorite_time = PBField.initUInt64(0);
    public oidb_0xb40$FavoriteSummary msg_favorite_summary = new MessageMicro<oidb_0xb40$FavoriteSummary>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$FavoriteSummary
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"msg_link_summary"}, new Object[]{null}, oidb_0xb40$FavoriteSummary.class);
        public oidb_0xb40$LinkSummary msg_link_summary = new MessageMicro<oidb_0xb40$LinkSummary>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$LinkSummary
            public static final int Audio = 2;
            public static final int Video = 1;
            public static final int Web = 0;
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_brief;
            public final PBBytesField bytes_publisher;
            public final PBBytesField bytes_resource_uri;
            public final PBBytesField bytes_title;
            public final PBBytesField bytes_type;
            public final PBBytesField bytes_uri;
            public final PBRepeatMessageField<oidb_0xb40$PicInfo> rpt_msg_pic_info;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"bytes_uri", "bytes_title", "bytes_publisher", "bytes_brief", "rpt_msg_pic_info", "bytes_type", "bytes_resource_uri"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, null, byteStringMicro, byteStringMicro}, oidb_0xb40$LinkSummary.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_uri = PBField.initBytes(byteStringMicro);
                this.bytes_title = PBField.initBytes(byteStringMicro);
                this.bytes_publisher = PBField.initBytes(byteStringMicro);
                this.bytes_brief = PBField.initBytes(byteStringMicro);
                this.rpt_msg_pic_info = PBField.initRepeatMessage(oidb_0xb40$PicInfo.class);
                this.bytes_type = PBField.initBytes(byteStringMicro);
                this.bytes_resource_uri = PBField.initBytes(byteStringMicro);
            }
        };
    };
    public oidb_0xb40$FavoriteExtInfo msg_favorite_ext_info = new MessageMicro<oidb_0xb40$FavoriteExtInfo>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$FavoriteExtInfo
        public static final int Article = 1;
        public static final int PictureCollection = 3;
        public static final int Video = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_type", "uint32_video_duration"}, new Object[]{0, 0}, oidb_0xb40$FavoriteExtInfo.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"bytes_rowkey", "rpt_bytes_cid", "msg_author", "uint64_favorite_time", "msg_favorite_summary", "msg_favorite_ext_info"}, new Object[]{byteStringMicro, byteStringMicro, null, 0L, null, null}, oidb_0xb40$FavoriteItem.class);
    }
}
