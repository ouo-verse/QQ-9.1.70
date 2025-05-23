package tencent.im.oidb.cmd0xb3e;

import com.tencent.mobileqq.pb.MessageMicro;
import tencent.im.oidb.gallery.gallery$GalleryInfo;
import tencent.im.oidb.gallery.gallery$GalleryList;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb3e$RspBody extends MessageMicro<cmd0xb3e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_gallery_info", "msg_gallery_list"}, new Object[]{null, null}, cmd0xb3e$RspBody.class);
    public gallery$GalleryInfo msg_gallery_info = new gallery$GalleryInfo();
    public gallery$GalleryList msg_gallery_list = new gallery$GalleryList();
}
