import { Injectable, Renderer2, RendererFactory2 } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LandbotService {
  private renderer: Renderer2;
  private isLandbotInitialized = false;

  constructor(rendererFactory: RendererFactory2) {
    this.renderer = rendererFactory.createRenderer(null, null);
  }

  initLandbot(): void {
    if (!this.isLandbotInitialized) {
      const s = this.renderer.createElement('script');
      s.type = 'text/javascript';
      s.async = true;
      this.renderer.listen(s, 'load', () => {
        const myLandbot = new (window as any).Landbot.Livechat({
          configUrl: 'https://storage.googleapis.com/landbot.online/v3/H-1781638-ASR0QYEHV3KRIT5O/index.json',
        });
      });
      s.src = 'https://cdn.landbot.io/landbot-3/landbot-3.0.0.js';
      const x = this.renderer.selectRootElement('script', true);
      this.renderer.insertBefore(x.parentNode, s, x);
      this.isLandbotInitialized = true;
    }
  }
}
