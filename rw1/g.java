package rw1;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ac;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.h;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import rw1.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, WeakReference<a>> f432613a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static g f432614b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b implements VideoConverter.Processor {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<QQAppInterface> f432627a;

        /* renamed from: b, reason: collision with root package name */
        final String f432628b;

        /* renamed from: c, reason: collision with root package name */
        final String f432629c;

        /* renamed from: d, reason: collision with root package name */
        ac.a f432630d;

        /* renamed from: e, reason: collision with root package name */
        c f432631e;

        b(WeakReference<QQAppInterface> weakReference, String str, String str2, ac.a aVar, c cVar) {
            this.f432627a = weakReference;
            this.f432628b = str2;
            this.f432629c = str;
            this.f432631e = cVar;
            if (str2 != null) {
                this.f432630d = aVar;
                return;
            }
            throw new IllegalArgumentException("null == outputFilePath");
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public VideoConverterConfig getEncodeConfig(int i3, int i16) {
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            videoConverterConfig.output = this.f432628b;
            ac.a aVar = this.f432630d;
            videoConverterConfig.scaleRate = aVar.f287762e;
            videoConverterConfig.videoFrameRate = (int) aVar.f287761d;
            videoConverterConfig.videoBitRate = (int) aVar.f287760c;
            return videoConverterConfig;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
            if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
            }
            c cVar = this.f432631e;
            if (cVar != null) {
                cVar.b(3);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
            }
            c cVar = this.f432631e;
            if (cVar != null) {
                cVar.b(2);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + i3);
            }
            c cVar = this.f432631e;
            if (cVar == null || i3 < 0 || i3 > 10000) {
                return;
            }
            cVar.a(i3 / 10000.0f);
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
            if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
            }
            c cVar = this.f432631e;
            if (cVar != null) {
                cVar.b(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface c {
        void a(float f16);

        void b(int i3);
    }

    static {
        URLDrawableHelper.initVideoAIOSizeByDpc();
    }

    g() {
    }

    public static g b() {
        if (f432614b == null) {
            f432614b = new g();
        }
        return f432614b;
    }

    public a a(long j3) {
        WeakReference<a> weakReference;
        ConcurrentHashMap<Long, WeakReference<a>> concurrentHashMap = f432613a;
        if (!concurrentHashMap.containsKey(Long.valueOf(j3)) || (weakReference = concurrentHashMap.get(Long.valueOf(j3))) == null) {
            return null;
        }
        return weakReference.get();
    }

    public void c(long j3) {
        a a16 = a(j3);
        if (a16 != null) {
            a16.g();
        }
        f432613a.remove(Long.valueOf(j3));
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        MsgRecord f432615a;

        /* renamed from: b, reason: collision with root package name */
        MsgElement f432616b;

        /* renamed from: c, reason: collision with root package name */
        private VideoConverter f432617c;

        /* renamed from: d, reason: collision with root package name */
        private String f432618d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<QQAppInterface> f432619e;

        /* renamed from: f, reason: collision with root package name */
        private IGuildAIOMediaApi.a f432620f;

        /* renamed from: g, reason: collision with root package name */
        private WeakReference<Context> f432621g;

        /* renamed from: h, reason: collision with root package name */
        private String f432622h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f432623i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f432624j = false;

        /* renamed from: k, reason: collision with root package name */
        private boolean f432625k = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: rw1.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        public class C11166a implements c {
            C11166a() {
            }

            @Override // rw1.g.c
            public void a(float f16) {
                if (a.this.f432620f != null) {
                    a.this.f432620f.c(a.this.f432615a, f16);
                }
            }

            @Override // rw1.g.c
            public void b(int i3) {
                QLog.d("GuildAIOVideoCompressProcessor", 1, "hardware compress finish code: " + i3);
                if (a.this.f432620f != null) {
                    a.this.f432620f.c(a.this.f432615a, 1.0f);
                }
            }
        }

        public a(MsgRecord msgRecord, MsgElement msgElement, AppRuntime appRuntime, Context context, boolean z16, IGuildAIOMediaApi.a aVar) {
            this.f432623i = false;
            this.f432615a = msgRecord;
            this.f432616b = msgElement;
            this.f432621g = new WeakReference<>(context);
            this.f432620f = aVar;
            this.f432619e = new WeakReference<>((QQAppInterface) appRuntime);
            this.f432623i = z16;
        }

        private int c() {
            if (!TextUtils.isEmpty(this.f432616b.getVideoElement().getVideoMd5())) {
                if (!QLog.isColorLevel()) {
                    return 5;
                }
                QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: Md5 not null, Compressed has been done, msgId=" + h());
                return 5;
            }
            String filePath = this.f432616b.getVideoElement().getFilePath();
            if (!TextUtils.isEmpty(filePath) && FileUtils.fileExistsAndNotEmpty(filePath)) {
                return 1;
            }
            if (!QLog.isColorLevel()) {
                return 3;
            }
            QLog.e("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=" + filePath);
            return 3;
        }

        private boolean d() {
            WeakReference<Context> weakReference = this.f432621g;
            return (weakReference == null || weakReference.get() == null || this.f432615a == null || this.f432616b.getVideoElement() == null) ? false : true;
        }

        private int e(String str, String str2) {
            String str3;
            long currentTimeMillis = System.currentTimeMillis();
            ac.b b16 = ac.b(this.f432619e.get());
            ac.c c16 = ac.c(str);
            final boolean d16 = ac.d(c16, b16);
            this.f432625k = d16;
            if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 1, "CompressTask, isNeedCompress = " + d16);
            }
            if (this.f432620f != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: rw1.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.a.this.i(d16);
                    }
                });
            }
            int i3 = -1;
            if (!d16) {
                return -1;
            }
            ac.a a16 = ac.a(c16, b16, this.f432623i);
            b bVar = new b(this.f432619e, str, str2, a16, new C11166a());
            VideoConverter videoConverter = new VideoConverter(new h());
            this.f432617c = videoConverter;
            videoConverter.setCompressMode(1);
            int startCompress = this.f432617c.startCompress(this.f432621g.get(), str, bVar, true);
            if (startCompress != 0 && startCompress != -1002) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
                }
                IGuildAIOMediaApi.a aVar = this.f432620f;
                if (aVar != null) {
                    aVar.c(this.f432615a, 1.0f);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAIOVideoCompressProcessor", 2, "\u4e0d\u652f\u6301\u786c\u4ef6\u538b\u7f29\uff0c\u4e0d\u7ba1\u8f6f\u4ef6\u538b\u7f29\u6210\u529f\u6216\u5931\u8d25\uff0c\u5747\u9ed8\u8ba4\u5c55\u793a\u5b8c\u6574\u547c\u5438\u5708");
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
                }
                i3 = 0;
            }
            if (i3 == 0) {
                str3 = str2;
            } else if (ShortVideoTrimmer.initVideoTrim(this.f432621g.get())) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: Try to compress by ShortVideoTrimmer.compressVideo");
                }
                VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
                videoConverterConfig.isNeedCompress = true;
                videoConverterConfig.rotate = String.valueOf(c16.f287779d);
                videoConverterConfig.srcWidth = c16.f287777b;
                videoConverterConfig.srcHeight = c16.f287778c;
                videoConverterConfig.destWidth = a16.f287758a;
                videoConverterConfig.destHeight = a16.f287759b;
                videoConverterConfig.destQmax = 25;
                videoConverterConfig.videoFrameRate = (int) a16.f287761d;
                videoConverterConfig.videoBitRate = (int) (a16.f287760c / 1024);
                str3 = str2;
                i3 = ShortVideoTrimmer.compressVideo(this.f432621g.get(), str, str3, videoConverterConfig);
                if (i3 == 0) {
                    QLog.d("GuildAIOVideoCompressProcessor", 1, "CompressTask, step:compress completed by ShortVideoTrimmer.compressVideo");
                } else {
                    QLog.d("GuildAIOVideoCompressProcessor", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + i3);
                }
            } else {
                str3 = str2;
                this.f432622h = this.f432618d;
                QLog.e("GuildAIOVideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer init failure, ignore compress, msgIdStr = " + h());
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "initVideoTrimError", true, 0L, 0L, (HashMap<String, String>) null, "", false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress retCode=" + i3 + ", msgIdStr = " + h());
            }
            this.f432622h = i3 == 0 ? str3 : this.f432618d;
            long length = new File(str).length();
            long length2 = new File(this.f432622h).length();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer compress, cost:" + currentTimeMillis2 + "ms, fileSourceSize=" + length + ", fileTargetSize=" + length2 + ", msgIdStr = " + h());
            }
            return i3;
        }

        private String h() {
            String str;
            MsgRecord msgRecord = this.f432615a;
            if (msgRecord != null) {
                str = String.valueOf(msgRecord.getMsgId());
            } else {
                str = "";
            }
            return "msgId = " + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(boolean z16) {
            this.f432620f.a(this.f432615a, z16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            if (!d()) {
                return 7;
            }
            int c16 = c();
            if (c16 != 1) {
                return Integer.valueOf(c16);
            }
            String filePath = this.f432616b.getVideoElement().getFilePath();
            this.f432618d = filePath;
            String shortVideoCompressPath = ShortVideoUtils.getShortVideoCompressPath(filePath, "mp4");
            if (TextUtils.isEmpty(shortVideoCompressPath)) {
                QLog.e("GuildAIOVideoCompressProcessor", 2, "CompressTask, fail for getShortVideoCompressPath is empty");
                return 5;
            }
            if (this.f432623i) {
                shortVideoCompressPath = ShortVideoUtils.getShortVideoRawCompressPath(filePath, "mp4");
                long length = new File(filePath).length();
                this.f432624j = length >= ShortVideoConstants.VIDEO_SIZE_LIMIT;
                boolean isH265FormatShortVideo = ShortVideoUtils.isH265FormatShortVideo(this.f432618d);
                if (isH265FormatShortVideo) {
                    this.f432624j = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, msgId:" + h() + ", mRawCompress:" + this.f432624j + ", output:" + shortVideoCompressPath + ", isH265:" + isH265FormatShortVideo + ", size:" + length);
                }
            }
            if (TextUtils.isEmpty(shortVideoCompressPath)) {
                QLog.e("GuildAIOVideoCompressProcessor", 2, "CompressTask, fail for getShortVideoRawCompressPath is empty");
                return 5;
            }
            if (this.f432623i && !this.f432624j) {
                this.f432622h = this.f432618d;
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, msgId:" + h());
                }
                IGuildAIOMediaApi.a aVar = this.f432620f;
                if (aVar != null) {
                    aVar.c(this.f432615a, 1.0f);
                }
            } else if (FileUtils.fileExistsAndNotEmpty(shortVideoCompressPath)) {
                this.f432622h = shortVideoCompressPath;
                QLog.d("GuildAIOVideoCompressProcessor", 1, "CompressTask, step: Compressed file has exists, videoPath:" + shortVideoCompressPath + ", msgId = " + h());
                IGuildAIOMediaApi.a aVar2 = this.f432620f;
                if (aVar2 != null) {
                    aVar2.c(this.f432615a, 1.0f);
                }
            } else {
                int e16 = e(filePath, shortVideoCompressPath);
                long length2 = new File(filePath).length();
                long length3 = new File(shortVideoCompressPath).length();
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask\uff0cstep: ShortVideoTrimmer Over fileSourceSize=" + length2 + ", fileTargetSize=" + length3 + ", msgId = " + h() + ", videoInput=" + filePath + ", videoPath=" + this.f432622h);
                }
                if (e16 != 0) {
                    this.f432622h = this.f432618d;
                } else if (length3 > length2) {
                    FileUtils.deleteFile(shortVideoCompressPath);
                    this.f432622h = this.f432618d;
                } else {
                    this.f432622h = shortVideoCompressPath;
                }
            }
            if (isCancelled()) {
                return 11;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath = " + this.f432622h + ", videoInput = " + filePath + ", msgId = " + h());
            }
            if (!TextUtils.isEmpty(this.f432622h) && FileUtils.fileExistsAndNotEmpty(this.f432622h)) {
                File file = new File(this.f432622h);
                this.f432616b.getVideoElement().setFilePath(this.f432622h);
                this.f432616b.getVideoElement().setFileSize((int) file.length());
                return 1;
            }
            QLog.e("GuildAIOVideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath not exists!!, path = " + this.f432622h + ", msgId = " + h());
            return 3;
        }

        public boolean g() {
            VideoConverter videoConverter = this.f432617c;
            if (videoConverter != null) {
                return videoConverter.cancelCompress();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            QLog.d("GuildAIOVideoCompressProcessor", 1, "CompressTask onPostExecute(): result = " + num + ", " + h());
            IGuildAIOMediaApi.a aVar = this.f432620f;
            if (aVar != null) {
                aVar.b(this.f432615a, num.intValue() != 1 ? 2 : 1);
            } else if (QLog.isColorLevel()) {
                QLog.d("GuildAIOVideoCompressProcessor", 2, "onPostExecute, mListener is null ," + h());
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            String shortVideoCompressPath;
            super.onCancelled();
            String shortVideoCompressPath2 = ShortVideoUtils.getShortVideoCompressPath(this.f432618d, "mp4");
            if (!TextUtils.isEmpty(shortVideoCompressPath2)) {
                FileUtils.deleteFile(shortVideoCompressPath2);
            }
            if (this.f432623i) {
                shortVideoCompressPath = ShortVideoUtils.getShortVideoRawCompressPath(this.f432618d, "mp4");
            } else {
                shortVideoCompressPath = ShortVideoUtils.getShortVideoCompressPath(this.f432618d, "mp4");
            }
            if (!TextUtils.isEmpty(shortVideoCompressPath)) {
                FileUtils.deleteFile(shortVideoCompressPath);
            }
            IGuildAIOMediaApi.a aVar = this.f432620f;
            if (aVar != null) {
                aVar.b(this.f432615a, 3);
            }
        }

        public void k(IGuildAIOMediaApi.a aVar) {
            if (aVar == null) {
                return;
            }
            this.f432620f = aVar;
            if (AsyncTask.Status.FINISHED == getStatus()) {
                IGuildAIOMediaApi.a aVar2 = this.f432620f;
                if (aVar2 != null) {
                    aVar2.b(this.f432615a, 1);
                    return;
                }
                return;
            }
            if (isCancelled()) {
                IGuildAIOMediaApi.a aVar3 = this.f432620f;
                if (aVar3 != null) {
                    aVar3.b(this.f432615a, 3);
                    return;
                }
                return;
            }
            IGuildAIOMediaApi.a aVar4 = this.f432620f;
            if (aVar4 != null) {
                aVar4.a(this.f432615a, this.f432625k);
            }
        }
    }

    public void d(long j3, a aVar) {
        if (aVar != null) {
            WeakReference<a> weakReference = new WeakReference<>(aVar);
            f432613a.put(Long.valueOf(j3), weakReference);
            Utils.executeAsyncTaskOnSerialExcuter(weakReference.get(), new Void[0]);
        }
    }
}
