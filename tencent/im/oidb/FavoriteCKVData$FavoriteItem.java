package tencent.im.oidb;

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
public final class FavoriteCKVData$FavoriteItem extends MessageMicro<FavoriteCKVData$FavoriteItem> {
    public static final int Kandian = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 802}, new String[]{"uint32_favorite_source", "msg_kandian_favorite_item"}, new Object[]{0, null}, FavoriteCKVData$FavoriteItem.class);
    public final PBUInt32Field uint32_favorite_source = PBField.initUInt32(0);
    public FavoriteCKVData$KandianFavoriteItem msg_kandian_favorite_item = new MessageMicro<FavoriteCKVData$KandianFavoriteItem>() { // from class: tencent.im.oidb.FavoriteCKVData$KandianFavoriteItem
        public static final int Link = 2;
        public static final int Valid = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 64, 72, 82}, new String[]{"msg_favorite_ext_info", "rpt_bytes_cid", "uint32_type", "uint32_status", "msg_author", "uint64_create_time", "uint64_favorite_time", "uint64_modify_time", "uint64_data_sync_time", "msg_favorite_summary"}, new Object[]{null, ByteStringMicro.EMPTY, 0, 0, null, 0L, 0L, 0L, 0L, null}, FavoriteCKVData$KandianFavoriteItem.class);
        public FavoriteCKVData$KandianFavoriteBizData msg_favorite_ext_info = new MessageMicro<FavoriteCKVData$KandianFavoriteBizData>() { // from class: tencent.im.oidb.FavoriteCKVData$KandianFavoriteBizData
            public static final int Article = 1;
            public static final int PictureCollection = 3;
            public static final int Video = 2;
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_account_name;
            public final PBBytesField bytes_rowkey;
            public final PBUInt32Field uint32_feeds_type;
            public final PBUInt32Field uint32_pic_num;
            public final PBUInt32Field uint32_type;
            public final PBUInt32Field uint32_video_duration;
            public final PBUInt32Field uint32_video_type;
            public final PBUInt64Field uint64_account_id;
            public final PBUInt64Field uint64_feeds_id;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72}, new String[]{"bytes_rowkey", "uint32_type", "uint32_video_duration", "uint32_pic_num", "uint64_account_id", "bytes_account_name", "uint32_video_type", "uint64_feeds_id", "uint32_feeds_type"}, new Object[]{byteStringMicro, 0, 0, 0, 0L, byteStringMicro, 0, 0L, 0}, FavoriteCKVData$KandianFavoriteBizData.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_rowkey = PBField.initBytes(byteStringMicro);
                this.uint32_type = PBField.initUInt32(0);
                this.uint32_video_duration = PBField.initUInt32(0);
                this.uint32_pic_num = PBField.initUInt32(0);
                this.uint64_account_id = PBField.initUInt64(0L);
                this.bytes_account_name = PBField.initBytes(byteStringMicro);
                this.uint32_video_type = PBField.initUInt32(0);
                this.uint64_feeds_id = PBField.initUInt64(0L);
                this.uint32_feeds_type = PBField.initUInt32(0);
            }
        };
        public final PBRepeatField<ByteStringMicro> rpt_bytes_cid = PBField.initRepeat(PBBytesField.__repeatHelper__);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_status = PBField.initUInt32(0);
        public FavoriteCKVData$Author msg_author = new FavoriteCKVData$Author();
        public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_favorite_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_modify_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_data_sync_time = PBField.initUInt64(0);
        public FavoriteCKVData$FavoriteSummary msg_favorite_summary = new MessageMicro<FavoriteCKVData$FavoriteSummary>() { // from class: tencent.im.oidb.FavoriteCKVData$FavoriteSummary
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"msg_link_summary"}, new Object[]{null}, FavoriteCKVData$FavoriteSummary.class);
            public FavoriteCKVData$LinkSummary msg_link_summary = new MessageMicro<FavoriteCKVData$LinkSummary>() { // from class: tencent.im.oidb.FavoriteCKVData$LinkSummary
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
                public final PBRepeatMessageField<FavoriteCKVData$PicInfo> rpt_msg_pic_info;

                static {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"bytes_uri", "bytes_title", "bytes_publisher", "bytes_brief", "rpt_msg_pic_info", "bytes_type", "bytes_resource_uri"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, null, byteStringMicro, byteStringMicro}, FavoriteCKVData$LinkSummary.class);
                }

                {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    this.bytes_uri = PBField.initBytes(byteStringMicro);
                    this.bytes_title = PBField.initBytes(byteStringMicro);
                    this.bytes_publisher = PBField.initBytes(byteStringMicro);
                    this.bytes_brief = PBField.initBytes(byteStringMicro);
                    this.rpt_msg_pic_info = PBField.initRepeatMessage(FavoriteCKVData$PicInfo.class);
                    this.bytes_type = PBField.initBytes(byteStringMicro);
                    this.bytes_resource_uri = PBField.initBytes(byteStringMicro);
                }
            };
        };
    };
}
