package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery$GalleryList extends MessageMicro<gallery$GalleryList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_gallery_info"}, new Object[]{null}, gallery$GalleryList.class);
    public final PBRepeatMessageField<gallery$GalleryInfo> rpt_msg_gallery_info = PBField.initRepeatMessage(gallery$GalleryInfo.class);
}
