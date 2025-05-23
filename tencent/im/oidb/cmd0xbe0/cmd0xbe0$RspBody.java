package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.gallery.gallery$GalleryInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbe0$RspBody extends MessageMicro<cmd0xbe0$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_more_gallery", "msg_next_gallery", "uint32_is_end"}, new Object[]{null, null, 0}, cmd0xbe0$RspBody.class);
    public cmd0xbe0$MoreGallery msg_more_gallery = new MessageMicro<cmd0xbe0$MoreGallery>() { // from class: tencent.im.oidb.cmd0xbe0.cmd0xbe0$MoreGallery
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_gallery_info"}, new Object[]{null}, cmd0xbe0$MoreGallery.class);
        public final PBRepeatMessageField<gallery$GalleryInfo> rpt_msg_gallery_info = PBField.initRepeatMessage(gallery$GalleryInfo.class);
    };
    public cmd0xbe0$NextGallery msg_next_gallery = new MessageMicro<cmd0xbe0$NextGallery>() { // from class: tencent.im.oidb.cmd0xbe0.cmd0xbe0$NextGallery
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_gallery_info", "rpt_msg_gallery_info"}, new Object[]{null, null}, cmd0xbe0$NextGallery.class);
        public gallery$GalleryInfo msg_gallery_info = new gallery$GalleryInfo();
        public final PBRepeatMessageField<gallery$GalleryInfo> rpt_msg_gallery_info = PBField.initRepeatMessage(gallery$GalleryInfo.class);
    };
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
}
